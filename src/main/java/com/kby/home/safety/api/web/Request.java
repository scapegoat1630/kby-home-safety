package com.kby.home.safety.api.web;

/**
 * Created by zhangpeng12 on 2017/5/15.
 */
public class Request {
    private String RequestId;
    private Integer accessKey;
    private String signature;

    public String getRequestId() {
        return RequestId;
    }

    public void setRequestId(String requestId) {
        RequestId = requestId;
    }



    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(Integer accessKey) {
        this.accessKey = accessKey;
    }
}
