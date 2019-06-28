package com.pgleon.cboot.exception;

/**
 * @author: leon
 * @Date: 2019-06-25 16:17
 * @Description:
 */
public class SignException extends Exception  {

    public SignException(String message) {
        super(message);
    }

    public SignException(Exception e) {
        super(e);
    }

    public static class SignParamIllegalException extends SignException {

        public SignParamIllegalException(String message) {
            super(message);
        }
    }

    public static class SignVersionIllegalException extends SignException {

        public SignVersionIllegalException(String message) {
            super(message);
        }
    }

    public static class SignTimeoutException extends SignException {

        public SignTimeoutException(String message) {
            super(message);
        }
    }

}
