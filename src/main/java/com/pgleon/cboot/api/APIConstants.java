package com.pgleon.cboot.api;



public class APIConstants {

    public interface Headers {

        String EBT_Authorization = "C-ARC-Authorization";
        String EBT_TOKEN = "C-ARC-Token";

    }

    public interface StatParams {

        String APP_ID = "app_id";
        String APP_VERSION = "app_version";
        String APP_VERSION_NAME = "app_version_name";
        String APP_SOURCE = "app_source";
        String APP_OS = "app_os";
        String DEVICE_ID = "deviceId";

    }
}