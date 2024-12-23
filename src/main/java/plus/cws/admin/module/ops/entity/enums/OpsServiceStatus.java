package plus.cws.admin.module.ops.entity.enums;

import lombok.Getter;

/**
 * 服务状态枚举类
 */
@Getter
public enum OpsServiceStatus {
    EX("error","未知错误"),
    START("start","运行中"),
    STOP("stop","已停止");


    private final String statusCode;
    private final String statusMsg;

    OpsServiceStatus(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

}
