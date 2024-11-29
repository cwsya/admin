package plus.cws.admin.module.ops.entity.vo;

import lombok.Data;
import plus.cws.admin.module.ops.entity.enums.OpsServiceStatus;

@Data
public class OpsServiceVo {

    /**
     * 服务ID 数据库中唯一标识
     */
    private String id;
    /**
     * 服务名称
     */
    private String serviceName;
    /**
     * 服务描述
     */
    private String serviceNote;
    /**
     * 启动脚本
     */
    private String startScript;
    /**
     * 停止脚本
     */
    private String stopScript;
    /**
     * 获取状态脚本
     */
    private String statusScript;
    /**
     * 当前状态 0-未启动 1-已启动
     */
    private OpsServiceStatus status;

    /**
     * 当前状态
     */
    private String statusCode;

    /**
     * 当前状态信息
     */
    private String statusMsg;

    /**
     * 获取日志脚本
     */
    private String logScript;


    public void setStatus(OpsServiceStatus status) {
        this.status = status;
        this.statusCode = status.getStatusCode();
        this.statusMsg = status.getStatusMsg();
    }
}
