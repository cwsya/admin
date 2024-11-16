package plus.cws.admin.module.common.entity;

import lombok.Data;

/**
 * 统一返回格式类
 *
 */
@Data
public class R<T> {

    /**
     * 返回状态值
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回数据
     */
    private T data;

    /**
     * 方法耗时
     */
    private long timestamp;

    public R(){}

    public static <T> R<T> ok() {
        R<T> rData = new R<>();
        rData.setCode(ResultCodeEnum.OK.getCode());
        rData.setMsg(ResultCodeEnum.OK.getMessage());
        return rData;
    }

    public static <T> R<T> ok(T data) {
        R<T> rData = new R<>();
        rData.setCode(ResultCodeEnum.OK.getCode());
        rData.setMsg(ResultCodeEnum.OK.getMessage());
        rData.setData(data);
        return rData;
    }

    public static <T> R<T> error() {
        R<T> rData = new R<>();
        rData.setCode(ResultCodeEnum.ERROR.getCode());
        rData.setMsg(ResultCodeEnum.ERROR.getMessage());
        return rData;
    }

    public static <T> R<T> error(Integer code,String msg) {
        R<T> rData = new R<>();
        rData.setCode(code);
        rData.setMsg(msg);
        return rData;
    }



    public static <T> R<T> error(ResultCodeEnum resultCodeEnum) {
        R<T> rData = new R<>();
        rData.setCode(resultCodeEnum.getCode());
        rData.setMsg(resultCodeEnum.getMessage());
        return rData;
    }

    public static <T> R<T> error(ResultCodeEnum resultCodeEnum,T data) {
        R<T> rData = new R<>();
        rData.setCode(resultCodeEnum.getCode());
        rData.setMsg(resultCodeEnum.getMessage());
        rData.setData(data);
        return rData;
    }




}