package plus.cws.admin.module.nacos.service;


import plus.cws.admin.module.nacos.entity.ConfigsRes;
import plus.cws.admin.module.nacos.entity.LoginRes;
import plus.cws.admin.module.nacos.entity.NameSpacesRes;

import java.util.List;

public interface INacosService {

    /**
     * 模拟nacos登录 获取token
     * @param url
     * @param username
     * @param password
     * @return type: ok/error token: token
     */
    LoginRes getToken(String url, String username, String password);

    List<NameSpacesRes> getNameSpaces(String url, String token);

    List<ConfigsRes> getConfigs(String url, String token, String tenant);





}
