package com.pgleon.cboot.auth;

import com.pgleon.rpcapi.user.enums.UserTypeEnum;
import com.pgleon.rpcapi.user.pojo.UserType;

/**
 * @Auther: leon
 * @Date: 2019-07-09 16:50
 * @Description: 用户信息数据传输对象
 */
public class UserIdentity {
    private String userId;
    private String token;
    private UserTypeEnum userTypeEnum;

    /**
     * 根据不用用户类型设置不同的属性值
     * @param token
     * @param userType
     * @return
     */
    public static UserIdentity build(String token, UserType userType) {
        UserIdentity userIdentity = new UserIdentity();
        userIdentity.setToken(token);
        userIdentity.setUserId(userType.getUserId());
        userIdentity.setUserTypeEnum(userType.getUserTypeEnum());
        return userIdentity;
    }

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
