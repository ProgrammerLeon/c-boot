package com.pgleon.cboot.pojo;

/**
 * Created by leon on 2019-06-25 11:18
 *
 * 签名信息数据传输对象
 */

public class AuthorizationDTO {

    private long signTimestamp;
    private String signVersion;
    private String deviceId;
    private String sign;

    public long getSignTimestamp() {
        return signTimestamp;
    }

    public void setSignTimestamp(long signTimestamp) {
        this.signTimestamp = signTimestamp;
    }

    public String getSignVersion() {
        return signVersion;
    }

    public void setSignVersion(String signVersion) {
        this.signVersion = signVersion;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
