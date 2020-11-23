package com.tedu.blog.pojo;


public class Result {

    Integer state;
    String msg;
    Object data;

    public Result() {}

    public Result(Integer state, String msg) {
        this.state = state;
        this.msg = msg;
    }

    public Result(Integer state, String msg, Object data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
