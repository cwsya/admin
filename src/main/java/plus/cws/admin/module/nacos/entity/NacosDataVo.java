package plus.cws.admin.module.nacos.entity;

@lombok.Data
public class NacosDataVo {
    private String url;
    private Boolean isLogin;
    private plus.cws.admin.module.nacos.entity.LoginRes loginData;
    private String loginDataErrorMsg;
    private Boolean isNameSpaces;
    private String NameSpacesErrorMsg;
    private java.util.List<NameSpacesRes> nameSpaces;
}
