package com.kby.home.safety.api.web;

/**
 * Created by zhangpeng12 on 2017/5/16.
 */
public class QueryAlertRequest extends Request {
    private Integer currPageNo ;
    private Integer pageSize;
    private String content;

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QueryAlertRequest{");
        sb.append("currPageNo=").append(currPageNo);
        sb.append(", pageSize=").append(pageSize);
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
