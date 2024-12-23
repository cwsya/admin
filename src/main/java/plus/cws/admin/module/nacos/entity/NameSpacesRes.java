package plus.cws.admin.module.nacos.entity;

import lombok.Data;

import java.util.List;


@Data
public class NameSpacesRes {
    private String namespace;
    private String namespaceShowName;
    private Integer quota;
    private Integer configCount;
    private Integer type;

    private List<ConfigsRes> configs;
    private String configsErrorMsg;
    private Boolean isConfigs;
}
