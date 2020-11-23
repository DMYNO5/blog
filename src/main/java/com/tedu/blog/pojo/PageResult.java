package com.tedu.blog.pojo;

import com.github.pagehelper.PageInfo;

public class PageResult extends Result{

    PageInfo pageInfo;

    public PageResult(Integer state, String msg, Object data) {
        super(state, msg, data);
    }

    public PageResult(Integer state, String msg) {
        super(state, msg);
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

}
