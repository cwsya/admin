package plus.cws.admin.module.nacos.service;


import plus.cws.admin.module.nacos.entity.ConfigsRes;
import plus.cws.admin.module.nacos.entity.LoginRes;
import plus.cws.admin.module.nacos.entity.NameSpacesRes;

import java.util.List;

public interface INacosService {

    /**
     * 模拟nacos登录 获取token
     * @param url nacos地址
     * @param username username
     * @param password password
     * @return type: ok/error token: token
     */
    LoginRes getToken(String url, String username, String password);

    /**
     * 获取命名空间列表信息
     * @param url nacos地址
     * @param token token
     * @return 命名空间列表
     */
    List<NameSpacesRes> getNameSpaces(String url, String token);


    /**
     * 获取命名空间下的配置信息
     * @param url nacos地址
     * @param token token
     * @param tenant 命名空间
     * @return 配置信息列表
     */
    List<ConfigsRes> getConfigs(String url, String token, String tenant);





}
