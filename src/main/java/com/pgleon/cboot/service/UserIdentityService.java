package com.pgleon.cboot.service;


import com.pgleon.cboot.exception.UserException;
import com.pgleon.cboot.pojo.UserIdentityDTO;

/**
 * @author leon
 * @Date: 2019-07-09 17:15
 * @Description:
 */
public interface UserIdentityService<T extends UserIdentityDTO>  {
    /**
     * 根据Token获取UserIdentity;
     */
    T get(String token) throws UserException;
}
