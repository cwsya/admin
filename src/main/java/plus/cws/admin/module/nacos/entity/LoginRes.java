package plus.cws.admin.module.nacos.entity;

import lombok.Data;


@Data
public class LoginRes {
    private String accessToken;
    private Integer tokenTtl;
    private String globalAdmin;
    private String username;
}
