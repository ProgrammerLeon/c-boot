package com.pgleon.cboot.api;

import org.springframework.http.HttpStatus;

/**
 * @Auther: leon
 * @Date: 2019-07-10 13:57
 * @Description:
 */
public class APIErrorResponse {
    private String code;
    private String message;
    private String type;

    public static APIErrorResponse badRequest(String message) {
        APIErrorResponse error = new APIErrorResponse();
        error.code = HttpStatus.BAD_REQUEST.value() + "";
        error.type = HttpStatus.BAD_REQUEST.getReasonPhrase();
        error.message = message;
        return error;
    }

    public static APIErrorResponse invalidSignRequest(String message) {

        return APIErrorResponseBuilder.anAPIErrorResponse()
                .withCode("100101")
                .withType("signIllegal")
                .withMessage(message)
                .build();
    }

    public static APIErrorResponse signTimeoutRequest(String message) {

        return APIErrorResponseBuilder.anAPIErrorResponse()
                .withCode("100102")
                .withType("signTimeout")
                .withMessage(message)
                .build();
    }

    public static APIErrorResponse signParamIllegalRequest(String message) {

        return APIErrorResponseBuilder.anAPIErrorResponse()
                .withCode("100103")
                .withType("signParamIllegal")
                .withMessage(message)
                .build();
    }

    public static APIErrorResponse invalidTokenRequest(String message) {

        return APIErrorResponseBuilder.anAPIErrorResponse()
                .withCode("100202")
                .withType("invalidToken")
                .withMessage(message)
                .build();
    }

    public static class APIErrorResponseBuilder {
        private String code;
        private String message;
        private String type;

        private APIErrorResponseBuilder() {
        }

        public static APIErrorResponseBuilder anAPIErrorResponse() {
            return new APIErrorResponseBuilder();
        }

        public APIErrorResponseBuilder withCode(String code) {
            this.code = code;
            return this;
        }

        public APIErrorResponseBuilder withMessage(String message) {
            this.message = message;
            return this;
        }

        public APIErrorResponseBuilder withType(String type) {
            this.type = type;
            return this;
        }

        public APIErrorResponseBuilder but() {
            return anAPIErrorResponse().withCode(code).withMessage(message).withType(type);
        }

        public APIErrorResponse build() {
            APIErrorResponse APIErrorResponse = new APIErrorResponse();
            APIErrorResponse.setCode(code);
            APIErrorResponse.setMessage(message);
            APIErrorResponse.setType(type);
            return APIErrorResponse;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
