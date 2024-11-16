package plus.cws.admin.module.vpn.service.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.noear.solon.annotation.Component;
import plus.cws.admin.module.vpn.service.IVpnService;

import java.util.HashMap;

/**
 * 可乐云订阅地址 可乐云.net
 */
@Component(value = "CokeCloud", typed=true)
public class CokeCloudVpnServiceImpl implements IVpnService {

    private String cloudUrl="http://47.239.221.214";

    @Override
    public String getVpnUrl() {


        JSONObject registerData = new JSONObject();
        registerData.set("email", RandomUtil.randomInt(1000000,999999999)+"@qq.com");
        registerData.set("email_code","");
        registerData.set("invite_code","");
        registerData.set("password",RandomUtil.randomString(10));
        registerData.set("recaptcha_data","");

        String register = HttpUtil.post(cloudUrl + "/api/v1/passport/auth/register", registerData.toJSONString(4));

        String token = JSONUtil.parseObj(register).getJSONObject("data").getStr("auth_data");

        String subscribe = HttpUtil.createGet(cloudUrl + "/api/v1/user/getSubscribe").addHeaders(new HashMap<String, String>(){{
            put("authorization",token);
        }}).execute().body();



        return JSONUtil.parseObj(subscribe).getJSONObject("data").getStr("subscribe_url");
    }
}
