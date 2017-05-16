package com.kby.home.safety.api.web;

import com.kby.home.safety.api.vo.BaseUser;

/**
 * Created by zhangpeng12 on 2017/5/16.
 */
public class UpdateUserRequest extends Request {

    private BaseUser user;

    public BaseUser getUser() {
        return user;
    }

    public void setUser(BaseUser user) {
        this.user = user;
    }

}
