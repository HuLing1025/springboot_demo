package com.example.demo.utils;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = -3948389268046368059L;

    private String code;

    private String msg;

    private Object data;

    public Result() {}

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static Result success() {
        Result Result = new Result();
        Result.setCode(ResponseCode.SUCCESS);
        return Result;
    }

    public static Result success(Object data) {
        Result Result = new Result();
        Result.setCode(ResponseCode.SUCCESS);
        Result.setData(data);
        return Result;
    }

    public static Result failure(String code, String msg) {
        Result Result = new Result();
        Result.setCode(code);
        Result.setMsg(msg);
        return Result;
    }

    public static Result failure(String code, String msg, Object data) {
        Result Result = new Result();
        Result.setCode(code);
        Result.setMsg(msg);
        Result.setData(data);
        return Result;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(final String code) {
        this.code = code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setMsg(final String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(final Object data) {
        this.data = data;
    }
}