package com.example.worldofzuul.common;

/**
 * @ClassName Result
 * @Description TODO
 * @Author Ducking
 * @DATE 2023/6/17 17:35
 * @Version 1.0
 */
public class Result {
    private boolean flag;
    private String msg;
    private Object data;

    public Result() {
    }

    public Result(boolean flag, String msg) {
        this.flag = flag;
        this.msg = msg;
    }

    public Result(boolean flag, String msg, Object data) {
        this.flag = flag;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
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
}
