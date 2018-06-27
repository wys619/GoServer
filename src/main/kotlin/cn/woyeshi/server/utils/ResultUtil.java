package cn.woyeshi.server.utils;

import cn.woyeshi.server.domain.Result;

public class ResultUtil {

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("操作成功");
        return result;
    }

    public static <T> Result success(T t) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg("操作成功");
        result.setData(t);
        return result;
    }


    public static <T> Result error(Integer code, String msg, T t) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(t);
        return result;
    }

    public static <T> Result success(String msg, T t) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        result.setData(t);
        return result;
    }

    public static Result success(String msg) {
        Result result = new Result();
        result.setCode(0);
        result.setMsg(msg);
        return result;
    }

}