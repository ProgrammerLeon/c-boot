package com.pgleon.cboot.auth;

import org.eclipse.jetty.server.UserIdentity;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * @Auther: leon
 * @Date: 2019-07-14 15:49
 * @Description: 自定义参数解析器
 */
public class UserIdentityHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return UserIdentity.class.isAssignableFrom(methodParameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Object attribute = nativeWebRequest.getAttribute(UserIdentityInterceptor.CURRENT_USER, RequestAttributes.SCOPE_REQUEST);
        return attribute;
    }
}
