package com.pgleon.cboot.service.impl;

import com.pgleon.cboot.exception.UserException;
import com.pgleon.cboot.auth.UserIdentity;
import com.pgleon.cboot.service.UserIdentityService;
import com.pgleon.rpcapi.user.UserService;
import com.pgleon.rpcapi.user.pojo.UserType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * @Auther: leon
 * @Date: 2019-07-14 15:34
 * @Description:
 */
public class UserIdentityServiceImpl implements UserIdentityService<UserIdentity> {

    @Autowired
    private UserService userService;
    /**
     * 根据Token获取UserIdentity;
     *
     * @param token
     */
    @Override
    public UserIdentity get(String token) throws UserException {
        UserType userType = userService.getUserTypeByToken(token);
        UserIdentity userIdentity = new UserIdentity();
        /**
         * 客户端用户
         */
        if (Optional.ofNullable(userType).isPresent() && userType.getUserTypeEnum().getType() == 1){

        }
        /**
         * 管理台用户
         */
        if (Optional.ofNullable(userType).isPresent() && userType.getUserTypeEnum().getType() == 0){

        }
        return UserIdentity.build(token, userType);
    }
}
