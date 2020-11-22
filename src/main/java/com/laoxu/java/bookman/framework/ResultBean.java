package com.laoxu.java.bookman.framework;

/**
 * @Description: 响应消息体
 * @Author laoxu
 * @Date 2019/12/21 9:50
 **/
public class ResultBean<T> {
    /**响应编码*/
    private int code;
    /**响应消息*/
    private String msg;
    /**数据总量*/
    private int count;
    /**数据*/
    private T data;

    public ResultBean() {
    }

    public ResultBean(int code, String msg, int count, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "R [code=" + code + ", msg=" + msg + ", count=" + count + ", data=" + data + "]";
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
