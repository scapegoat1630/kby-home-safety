package com.kby.home.safety.api.web;

/**
 * Created by zhangpeng12 on 2017/5/16.
 */
public class QueryAlertRequest extends Request {
    private Integer currPageNo ;
    private Integer pageSize;

    public Integer getCurrPageNo() {
        return currPageNo;
    }

    public void setCurrPageNo(Integer currPageNo) {
        this.currPageNo = currPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
