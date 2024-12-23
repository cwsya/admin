package plus.cws.admin.module.nacos.controller;

import cn.hutool.core.util.ObjUtil;
import lombok.extern.slf4j.Slf4j;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import plus.cws.admin.common.entity.R;
import plus.cws.admin.module.nacos.entity.ConfigsRes;
import plus.cws.admin.module.nacos.entity.LoginRes;
import plus.cws.admin.module.nacos.entity.NacosDataVo;
import plus.cws.admin.module.nacos.entity.NameSpacesRes;
import plus.cws.admin.module.nacos.service.INacosService;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Mapping("/nacos")
@Controller
public class NacosController {

    @Inject
    private INacosService nacosService;

    @Post
    @Mapping("/getData")
    public R<?> getData(String url) {

        // 前置参数处理
        {
            if (ObjUtil.isEmpty(url)) {
                return R.error();
            }
        }





        NacosDataVo nacosDataVo = new NacosDataVo();
        nacosDataVo.setUrl(url);


        LoginRes token = new LoginRes();
        try {
            token = nacosService.getToken(url, "nacos", "nacos");
            log.info("nacos采集 登录: {}", token);
            nacosDataVo.setIsLogin(true);
            nacosDataVo.setLoginData(token);
        }catch (Exception e) {
            nacosDataVo.setIsLogin(false);
            nacosDataVo.setLoginDataErrorMsg(e.getMessage());
            log.error("nacos采集 登录失败: {}", e.getMessage());
        }

        List<NameSpacesRes> nameSpaces=new ArrayList<>();

        try {
            nameSpaces = nacosService.getNameSpaces(url, token.getAccessToken());
            log.info("nacos采集 命名空间( {} ): {}", nameSpaces.size(), nameSpaces);
            nacosDataVo.setIsNameSpaces(true);
            nacosDataVo.setNameSpaces(nameSpaces);
        }catch (Exception e){
            nacosDataVo.setIsNameSpaces(false);
            nacosDataVo.setNameSpacesErrorMsg(e.getMessage());
            log.error("nacos采集 获取命名空间失败: {}", e.getMessage());
        }



        for (NameSpacesRes nameSpace : nameSpaces) {
            try {
                List<ConfigsRes> configs = nacosService.getConfigs(url, token.getAccessToken(), nameSpace.getNamespace());
                nameSpace.setConfigs(configs);
                nameSpace.setIsConfigs(true);
                log.info("nacos采集 配置: "+configs);
            }catch (Exception e){
                nameSpace.setIsConfigs(false);
                nameSpace.setConfigsErrorMsg(e.getMessage());
                log.error("nacos采集 获取配置失败: {}", e.getMessage());
            }
        }

        return R.ok(nacosDataVo);
    }

}
