package com.kby.home.safety.api.web;

import com.kby.home.safety.api.vo.UserVo;

/**
 * Created by zhangpeng12 on 2017/5/15.
 */
public class UserRegisterRequest extends Request {
    private UserVo user;

    public UserVo getUser() {
        return user;
    }

    public void setUser(UserVo user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRegisterRequest{");
        sb.append("user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
