package plus.cws.admin.module.nacos.service.impl;


import cn.hutool.core.util.ObjUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import org.noear.solon.annotation.Component;
import plus.cws.admin.module.nacos.entity.res.ConfigsRes;
import plus.cws.admin.module.nacos.entity.res.LoginRes;
import plus.cws.admin.module.nacos.entity.res.NameSpacesRes;
import plus.cws.admin.module.nacos.service.INacosService;

import java.util.HashMap;
import java.util.List;

@Component
public class NacosServiceImpl implements INacosService {


    @Override
    public LoginRes getToken(String url, String username, String password) {
        String post = HttpUtil.post(url + "/nacos/v1/auth/users/login", "username=" + username + "&password=" + password);
        try {
            return JSONUtil.parseObj(post).toBean(LoginRes.class);
        }catch (Exception e) {
            throw new RuntimeException(post);
        }
    }

    @Override
    public List<NameSpacesRes> getNameSpaces(String url, String token) {
        String data = HttpUtil.get(url + "/nacos/v1/console/namespaces", new HashMap<>() {{
            put("accessToken", token);
            put("namespaceId", "");
        }});
        try {
            return JSONUtil.parseObj(data).getJSONArray("data").toList(NameSpacesRes.class);
        }catch (Exception e) {
            throw new RuntimeException(data);
        }
    }

    @Override
    public List<ConfigsRes> getConfigs(String url, String token, String tenant) {
        String data = HttpUtil.get(url + "/nacos/v1/cs/configs", new HashMap<>() {{
            put("dataId", "");
            put("group", "");
            put("appName", "");
            put("config_tags", "");
            put("pageNo", "1");
            put("pageSize", "9999");
            put("tenant", tenant);
            put("search", "accurate");
            put("accessToken", ObjUtil.isNull(token) ? "" : token);
            put("username", "nacos");
        }});
        try {
            return JSONUtil.parseObj(data).getJSONArray("pageItems").toList(ConfigsRes.class);
        }catch (Exception e) {
            throw new RuntimeException(data);
        }
    }
}
