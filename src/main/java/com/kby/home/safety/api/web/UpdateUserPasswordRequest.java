package com.kby.home.safety.api.web;

/**
 * Created by zhangpeng12 on 2017/5/16.
 */
public class UpdateUserPasswordRequest extends Request{
    private String password;

    private String passwordRepeat;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordRepeat() {
        return passwordRepeat;
    }

    public void setPasswordRepeat(String passwordRepeat) {
        this.passwordRepeat = passwordRepeat;
    }
}
