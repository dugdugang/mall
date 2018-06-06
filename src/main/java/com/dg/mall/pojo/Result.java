package com.dg.mall.pojo;

public class Result {
    private int status;
    private String msg;
    private Object data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static Result ok() {
        Result result = new Result();
        result.setStatus(200);
        return result;
    }

    public static Result ok(Object object) {
        Result result = new Result();
        result.setStatus(200);
        result.setData(object);
        return result;
    }

    public static Result ok(String msg) {
        Result result = new Result();
        result.setStatus(200);
        result.setMsg(msg);
        return result;
    }

    public static Result ok(String msg, Object object) {
        Result result = new Result();
        result.setStatus(200);
        result.setMsg(msg);
        result.setData(object);
        return result;
    }

    public static Result err(String msg) {
        Result result = new Result();
        result.setStatus(-1);
        result.setMsg(msg);
        return result;
    }


}
