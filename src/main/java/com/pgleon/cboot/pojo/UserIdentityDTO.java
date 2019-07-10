package com.pgleon.cboot.pojo;

import com.pgleon.rpcapi.user.enums.UserTypeEnum;

/**
 * @Auther: leon
 * @Date: 2019-07-09 16:50
 * @Description: 用户信息数据传输对象
 */
public class UserIdentityDTO {
    private String userId;
    private String token;
    private UserTypeEnum userTypeEnum;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserTypeEnum getUserTypeEnum() {
        return userTypeEnum;
    }

    public void setUserTypeEnum(UserTypeEnum userTypeEnum) {
        this.userTypeEnum = userTypeEnum;
    }

    public Integer getUserIdAsInteger() {
        try {
            return Integer.parseInt(userId);
        } catch (Exception e) {
            return Integer.valueOf(0);
        }
    }
}
