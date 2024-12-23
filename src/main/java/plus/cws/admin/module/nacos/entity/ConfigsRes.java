package plus.cws.admin.module.nacos.entity;

import lombok.Data;

@Data
public class ConfigsRes {
    private String id;
    private String dataId;
    private String group;
    private String content;
    private String md5;
    private String tenant;
    private String appName;
    private String type;
}
