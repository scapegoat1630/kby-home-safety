package com.kby.home.safety.api.web;


/**
 * Created by zhangpeng12 on 2017/5/16.
 */
public class QueryAlertResponse extends Response {
    // 分页
    private Pagination pagination;

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }
}
