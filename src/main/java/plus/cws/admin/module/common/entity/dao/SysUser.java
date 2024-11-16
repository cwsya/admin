package plus.cws.admin.module.common.entity.dao;

import lombok.Data;
import org.noear.wood.annotation.PrimaryKey;

@Data
public class SysUser {

    /**
     * 用户id
     */
    @PrimaryKey
    private String id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
