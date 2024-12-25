package plus.cws.admin.module.nacos.entity.vo;

import plus.cws.admin.module.nacos.entity.res.LoginRes;
import plus.cws.admin.module.nacos.entity.res.NameSpacesRes;

@lombok.Data
public class NacosDataVo {
    private String url;
    private Boolean isLogin;
    private LoginRes loginData;
    private String loginDataErrorMsg;
    private Boolean isNameSpaces;
    private String NameSpacesErrorMsg;
    private java.util.List<NameSpacesRes> nameSpaces;
}
