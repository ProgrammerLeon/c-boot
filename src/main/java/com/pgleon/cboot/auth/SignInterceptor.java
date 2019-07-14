package com.pgleon.cboot.auth;

import com.pgleon.cboot.annotation.WithoutSign;
import com.pgleon.cboot.exception.SignException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: leon
 * @Date: 2019-06-25 16:01
 * @Description: 验签拦截器
 */
public class SignInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        if (null != handlerMethod.getBeanType().getAnnotation(WithoutSign.class)) {
            return true;
        }
        if (null != handlerMethod.getMethodAnnotation(WithoutSign.class)) {
            return true;
        }
        Authorization authInfo = SignUtils.parseAuthInfo(request);
        if (authInfo == null) {
            throw new SignException.SignParamIllegalException("签名信息缺少必要参数");
        }
        if (!SignUtils.checkSign(authInfo)) {
            throw new SignException("签名不正确");
        }
        if (SignUtils.checkTimeout(authInfo)) {
            throw new SignException.SignTimeoutException("签名超时，签名时间跟当前时间间隔太长，需要重签");
        }
        return super.preHandle(request, response, handler);
    }
}
