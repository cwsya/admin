package plus.cws.admin.module.ops.service.impl;

import cn.hutool.core.util.ObjUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.core.util.RuntimeUtil;
import org.noear.solon.annotation.Component;
import org.noear.wood.BaseMapper;
import org.noear.wood.annotation.Db;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import plus.cws.admin.common.entity.dao.OpsService;
import plus.cws.admin.module.ops.entity.enums.OpsServiceStatus;
import plus.cws.admin.module.ops.service.IServiceService;

import java.util.List;


@Component
public class ServiceService implements IServiceService {

    private static final Logger log = LoggerFactory.getLogger(ServiceService.class);
    @Db
    BaseMapper<OpsService> opsServiceBaseMapper;


    /**
     * @param serviceName 服务名称筛选条件
     * @return 服务列表
     */
    @Override
    public List<OpsService> getServices(String serviceName) {
        return opsServiceBaseMapper.selectList(mq -> {
                    mq.whereTrue();
                    if (ObjUtil.isNotEmpty(serviceName)) {
                        mq.andLk(OpsService::getServiceName, serviceName);
                    }
                }
        );
    }

    /**
     * @param service 需要检查的服务
     * @return 服务状态
     */
    @Override
    public OpsServiceStatus getServiceStatus(OpsService service) {

        String execStr;
        try {
            // 执行命令获取状态
            execStr = RuntimeUtil.execForStr(service.getStatusScript());

            log.info("{}服务状态返回值:\"{}\"", service.getServiceName(),execStr);

            execStr = execStr.replace("\n", "").replace("\r", "");
        }catch (Exception e){
            log.error("获取{}服务状态失败:{}",service.getServiceName(),e.getMessage());
            // 如果命令执行失败 则返回未知错误
            return OpsServiceStatus.EX;
        }

        if (ReUtil.count(service.getStartStatusRe(), execStr)>0) {
            return OpsServiceStatus.START;
        }else if (ReUtil.count(service.getStopStatusRe(), execStr)>0) {
            return OpsServiceStatus.STOP;
        }else {
            return OpsServiceStatus.EX;
        }
    }
}
