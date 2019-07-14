package com.pgleon.cboot.service;


import com.pgleon.cboot.exception.UserException;
import com.pgleon.cboot.auth.UserIdentity;

/**
 * @author leon
 * @Date: 2019-07-09 17:15
 * @Description:
 */
public interface UserIdentityService<T extends UserIdentity>  {
    /**
     * 根据Token获取UserIdentity;
     */
    T get(String token) throws UserException;
}
