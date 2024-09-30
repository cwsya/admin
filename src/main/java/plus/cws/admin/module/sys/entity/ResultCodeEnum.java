package plus.cws.admin.module.sys.entity;

/**
 * 状态码
 *
 */
public enum ResultCodeEnum {
 
    ok(200, "成功"),

    error(500, "未知错误");

 
    private final Integer code;
 
    private final String message;
 
    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

 
    public Integer getCode() {
        return code;
    }
 
    public String getMessage() {
        return message;
    }

}