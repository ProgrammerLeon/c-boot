package com.pgleon.cboot.utils;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ExecutionError;
import com.pgleon.cboot.exception.SignException;
import com.pgleon.cboot.pojo.AuthorizationDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Map;

/**
 * @Auther: leon
 * @Date: 2019-06-25 15:57
 * @Description:
 */
public class SignUtils {
    public static final int SIGN_EXPIRE_SECONDS = 20;
    private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);
    private static final Map<String, String> SIGN_KEY_MAP = ImmutableMap.<String, String>builder()
            .put("web-admin-v1.0", "b-mabda-0ma30mbm33")
            .build();

    /**
     * 从请求中解析AuthorizationDTO
     */
    public static AuthorizationDTO parseAuthInfo(HttpServletRequest request) throws SignException {
        String authorization = request.getHeader("C-ARC-Authorization");
        AuthorizationDTO authInfo = null;
        try {
            if (authorization != null) {
                authInfo = JSON.parseObject(authorization, AuthorizationDTO.class);
            }
        } catch (ExecutionError e) {
            logger.error("parseAuthInfo {}", authorization, e);
        }
        return authInfo;
    }


    /**
     * 验证签名是否过期;
     *
     * @return 如果过期, 返回true
     */
    public static boolean checkTimeout(AuthorizationDTO authInfo) {
        if (authInfo == null) {
            return false;
        }
        try {
            long signTimestamp = authInfo.getSignTimestamp();
            long tenSecondAgo = LocalDateTime.now().minusSeconds(SIGN_EXPIRE_SECONDS).toEpochSecond(ZoneOffset.ofHours(8)) * 1000;
            return signTimestamp < tenSecondAgo;
        } catch (Exception e) {
            logger.error("checkTimeout", e);
        }
        return false;
    }

    /**
     * 验证签名是否合法;
     *
     * @return 如果合法, 返回true
     */
    public static boolean checkSign(AuthorizationDTO authInfo) {
        if (authInfo == null) {
            return false;
        }
        String signVersion = authInfo.getSignVersion();
        String originKey = getOriginKeyBySignVersion(signVersion);
        if (originKey == null) {
            return false;
        }
        String sign = authInfo.getSign();
        String deviceId = authInfo.getDeviceId();
        long signTimestamp = authInfo.getSignTimestamp();
        String requestKey = md5(deviceId + originKey);
        String serverSign = md5(deviceId + signTimestamp + requestKey);
        return serverSign.equals(sign);
    }


    private static String md5(String string) {
        return DigestUtils.md5DigestAsHex(string.getBytes(Charsets.UTF_8));
    }

    private static String getOriginKeyBySignVersion(String signVersion) {
        return SIGN_KEY_MAP.get(signVersion);
    }



}
