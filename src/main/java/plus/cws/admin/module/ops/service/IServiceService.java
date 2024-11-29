package plus.cws.admin.module.ops.service;

import plus.cws.admin.common.entity.dao.OpsService;
import plus.cws.admin.module.ops.entity.enums.OpsServiceStatus;

import java.util.List;

public interface IServiceService {

    /**
     * 获取服务列表
     * @param serviceName 服务名称筛选条件
     * @return 服务列表
     */
    List<OpsService> getServices(String serviceName);


    /**
     * 获取当前服务状态
     * @param service 需要检查的服务
     * @return 状态枚举
     */
    OpsServiceStatus getServiceStatus(OpsService service);


}
