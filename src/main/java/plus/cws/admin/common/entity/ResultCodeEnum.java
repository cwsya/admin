package plus.cws.admin.common.entity;

/**
 * 状态码
 *
 */
public enum ResultCodeEnum {
 
    OK(200, "成功"),

    ERROR(500, "未知错误"),

    ERROR_LOGIN(510, "登录失败"),

    ERROR_AUTH(511, "您无权访问");

 
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