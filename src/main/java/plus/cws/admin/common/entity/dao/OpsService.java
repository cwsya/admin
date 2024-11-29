package plus.cws.admin.common.entity.dao;

import lombok.Data;
import org.noear.wood.annotation.PrimaryKey;

@Data
public class OpsService {
    /**
     * 服务ID 数据库中唯一标识
     */
    @PrimaryKey
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
     * 启动状态返回值
     */
    private String startStatusRe;

    /**
     * 停止脚本
     */
    private String stopScript;

    /**
     * 停止状态返回值
     */
    private String stopStatusRe;

    /**
     * 获取状态脚本
     */
    private String statusScript;
    /**
     * 获取日志脚本
     */
    private String logScript;
}
