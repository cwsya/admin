package plus.cws.admin.module.ops.controller;


import cn.hutool.core.bean.BeanUtil;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import plus.cws.admin.common.entity.R;
import plus.cws.admin.common.entity.dao.OpsService;
import plus.cws.admin.module.ops.entity.vo.OpsServiceVo;
import plus.cws.admin.module.ops.service.IServiceService;

import java.util.ArrayList;
import java.util.List;

@Mapping("/ops/service")
@Controller
public class ServiceController {

    @Inject
    private IServiceService serviceService;



    @Post
    @Mapping("/getServices")
    public R<?> getServices(String serviceName) {

        // 获取配置的服务列表
        List<OpsService> services = serviceService.getServices(serviceName);

        List<OpsServiceVo> opsServiceVos = new ArrayList<>();

        // 遍历服务列表，获取每个服务的状态
        for (OpsService service : services) {
            OpsServiceVo opsServiceVo = BeanUtil.copyProperties(service, OpsServiceVo.class);
            opsServiceVo.setStatus(serviceService.getServiceStatus(service));
            opsServiceVos.add(opsServiceVo);
        }

        return R.ok(opsServiceVos);
    }


}
