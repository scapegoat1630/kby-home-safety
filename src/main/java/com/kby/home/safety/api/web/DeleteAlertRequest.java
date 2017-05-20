package com.kby.home.safety.api.web;

import java.util.List;

/**
 * Created by zhangpeng12 on 2017/5/20.
 */
public class DeleteAlertRequest extends Request {
    private List<Integer> Ids;

    public List<Integer> getIds() {
        return Ids;
    }

    public void setIds(List<Integer> ids) {
        Ids = ids;
    }
}
