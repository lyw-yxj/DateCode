package com.newp.tliasproject.pojo;

public class Result {
    private Integer code;
    private String msg;
    private Object data;

    public Result(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    public Result() {
    }
    public static Result suceess(){
        Result r=new Result();
        r.setCode(1);
        r.setMsg("success");
        return r;
//确定数据
    }
    public static Result suceess(Object data){
        Result r=new Result();
        r.setCode(1);
        r.setMsg("success");
        r.setData(data);
        return r;

    }
    public static Result error(String msg){
        Result r=new Result();
        r.setCode(0);
        r.setMsg(msg);
        return r;

    }
}
