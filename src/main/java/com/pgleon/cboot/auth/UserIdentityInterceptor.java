package com.pgleon.cboot.auth;

import com.google.common.base.Strings;
import com.pgleon.cboot.exception.UserException;
import com.pgleon.cboot.api.APIConstants;
import com.pgleon.cboot.service.UserIdentityService;
import com.pgleon.rpcapi.user.enums.UserTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @author leon
 * @Date: 2019-07-09 16:53
 * @Description: 用户鉴权拦截器
 */
public class UserIdentityInterceptor extends HandlerInterceptorAdapter {
    public static final String CURRENT_USER = "CURRENT_USER";
    private static final Logger logger = LoggerFactory.getLogger(UserIdentityInterceptor.class);
    @Autowired
    private UserIdentityService userIdentityService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //HandlerMethod封装了很多属性，在访问请求方法的时候可以方便的访问到方法、方法参数、方法上的注解、所属类等并且对方法参数封装处理，也可以方便的访问到方法参数的注解等信息。
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        MethodParameter[] methodParameters = handlerMethod.getMethodParameters();
        boolean needUserIdentity = false;
        for (MethodParameter methodParameter : methodParameters) {
            if (UserIdentity.class.isAssignableFrom(methodParameter.getParameterType())) {
                needUserIdentity = true;
                break;
            }
        }
        if (!needUserIdentity) {
            return true;
        }
        String token = Optional.ofNullable(request.getHeader(APIConstants.Headers.TOKEN)).orElse(null);
        String userId = Optional.ofNullable(request.getHeader(APIConstants.Headers.USER_ID)).orElse(null);
        if (Strings.isNullOrEmpty(token)) {
            throw new UserException.TokenInvalidException("Token为空 : " + token);
        }
        UserIdentity userIdentity = null;
        try {
            userIdentity = userIdentityService.get(token);
        } catch (Exception e) {
            logger.error("preHandle", e);
            throw e;
        }
        if (userIdentity == null) {
            throw new UserException.TokenInvalidException("无效的Token : " + token);
        }
        Integer userIdByToken = userIdentity.getUserIdAsInteger();
        if (UserTypeEnum.ILLEGAL_USER.equals(userIdentity.getUserTypeEnum())) {
            throw new UserException.TokenInvalidException("无效的Token : " + token + ", " + UserTypeEnum.ILLEGAL_USER.getName() + " : " + userIdentity.getUserId());
        }
        // 传递了userId但跟Token不对应
        if (!Strings.isNullOrEmpty(userId) && !userId.equals(String.valueOf(userIdByToken))) {
            throw new UserException.TokenInvalidException("Token跟用户不匹配 : " + token);
        }
        request.setAttribute(CURRENT_USER, userIdentity);

        return super.preHandle(request, response, handler);
    }
}
