package plus.cws.admin.sys.auth.controller;


import cn.dev33.satoken.stp.StpUtil;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Post;
import plus.cws.admin.common.entity.R;
import plus.cws.admin.common.entity.dao.SysUser;
import plus.cws.admin.sys.auth.service.IAuthService;

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
//    @Post
//    @Mapping("/test")
//    public R<?> test(String userName,String password) {
//        //Solon.context().getBeansMapOfType(IVpnService.class)
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
//
//
//        return R.error(ResultCodeEnum.ERROR_LOGIN);
//    }

}
