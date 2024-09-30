package plus.cws.admin.module.sys.auth.entity;

import lombok.Data;
import org.noear.wood.annotation.PrimaryKey;

@Data
public class SysUser {

    @PrimaryKey
    private String id;
    private String userName;
    private String password;
}
