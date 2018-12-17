package com.example.utils.traceLog;

import java.util.UUID;

public class TraceLogUtils {

    public static String getTraceId(){
        return UUID.randomUUID().toString();
    }
}
