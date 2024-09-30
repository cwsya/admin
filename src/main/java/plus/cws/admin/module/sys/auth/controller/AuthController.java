package plus.cws.admin.module.sys.auth.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import org.noear.wood.BaseMapper;
import org.noear.wood.DataList;
import org.noear.wood.annotation.Db;
import plus.cws.admin.module.sys.auth.entity.SysUser;
import plus.cws.admin.module.sys.auth.mapper.AuthMapper;
import plus.cws.admin.module.sys.entity.R;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapping("/auth")
@Controller
public class AuthController {


    @Post
    @Mapping("/login")
    public R<?> login(String username, String password) {

        if("admin".equals(username) && "admin".equals(password)) {
            StpUtil.login(1);
            return R.ok(StpUtil.getTokenInfo());
        }
        return R.error();
    }

    @Post
    @Mapping("/isLogin")
    public R<?> isLogin() {

        return R.ok(StpUtil.isLogin());
    }

    @Db
    private AuthMapper authMapper;

    @Db
    private BaseMapper<SysUser> sysUserBaseMapper;

    @Post
    @Mapping("/test")
    public R<?> test(String userName) {

        List<SysUser> sysUsers = sysUserBaseMapper.selectList(mq->mq
                .where("1=1")
                .andEq(SysUser::getUserName,userName)
        );
        return R.ok(sysUsers);
    }

}
