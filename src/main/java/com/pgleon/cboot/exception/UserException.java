package com.pgleon.cboot.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author leon
 * @date: 2019-07-09 17:08
 * @Description:
 */
public class UserException extends Exception {
    private static final Logger logger = LoggerFactory.getLogger(UserException.class);

    public UserException() {
        this("");
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(Exception e) {
        super(e);
    }

    public static class TokenInvalidException extends UserException {
        public TokenInvalidException(String message) {
            super(message);
        }
    }
}
