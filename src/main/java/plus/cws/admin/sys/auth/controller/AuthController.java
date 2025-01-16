package plus.cws.admin.sys.auth.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import plus.cws.admin.common.entity.R;
import plus.cws.admin.common.entity.dao.SysUser;
import plus.cws.admin.sys.auth.entity.vo.SysUserVo;
import plus.cws.admin.sys.auth.service.IAuthService;

import java.util.HashMap;

@Mapping("/auth")
@Controller
public class AuthController {

    @Inject
    private IAuthService authService;


    @Post
    @Mapping("/login")
    public R<?> login(SysUser user) {

        String token = authService.loginByPassword(user);

        return R.ok(token);
    }

    @Post
    @Mapping("/isLogin")
    public R<?> isLogin() {
        return R.ok(StpUtil.isLogin());
    }


    @Post
    @Mapping("/info")
    public R<?> info() {
        SysUser info = authService.info(StpUtil.getLoginId().toString());
        SysUserVo sysUserVo = new SysUserVo();

        sysUserVo.setId(info.getId());
        sysUserVo.setUsername(info.getUsername());

        return R.ok(sysUserVo);
    }

    @Post
    @Mapping("/logout")
    public R<?> logout() {
        StpUtil.logout();
        return R.ok();
    }


//
//    @Db
//    private AuthMapper authMapper;
//
//    @Db
//    private BaseMapper<SysUser> sysUserBaseMapper;
//
//    @Inject
//    private IVpnService vpnService;
//
    @Post
    @Mapping("/test")
    public R<?> test(String userName,String password) {
        //Solon.context().getBeansMapOfType(IVpnService.class)
//        System.out.println(vpnService.getVpnUrl());
//        SysUser sysUsers = sysUserBaseMapper.selectItem(mq->mq
//                .whereTrue()
//                .andEq(SysUser::getUserName,userName)
//                .andEq(SysUser::getPassword,password)
//                .limit(1)
//        );
//
//        if (ObjUtil.isNotEmpty(sysUsers)) {
//            StpUtil.login(sysUsers.getId());
//            return R.ok(StpUtil.getTokenInfo());
//        }


        return R.ok(new HashMap<String,Object>(){{
            put("userName",userName);
            put("password",password);
        }});
    }

}
