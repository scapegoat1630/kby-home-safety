package com.kby.home.safety.api.web;

/**
 * Created by zhangpeng12 on 2017/5/15.
 */
public class Response<T> {
    private String error;
    private Boolean success;
    private  T result;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Response{");
        sb.append("error='").append(error).append('\'');
        sb.append(", success=").append(success);
        sb.append(", result=").append(result);
        sb.append('}');
        return sb.toString();
    }
}
