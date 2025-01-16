package plus.cws.admin.sys.auth.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjUtil;
import org.noear.solon.annotation.Component;
import org.noear.wood.BaseMapper;
import org.noear.wood.annotation.Db;
import plus.cws.admin.common.entity.dao.SysUser;
import plus.cws.admin.common.exception.LoginException;
import plus.cws.admin.sys.auth.service.IAuthService;

@Component
public class AuthServiceImpl implements IAuthService {


    @Db
    private BaseMapper<SysUser> sysUserBaseMapper;

    /**
     * 根据用户名密码登录
     *
     * @param user 用户信息
     * @return token
     */
    @Override
    public String loginByPassword(SysUser user) {

        //根据账号密码查询用户
        SysUser sysUsers = sysUserBaseMapper.selectItem(mq->mq
                .whereTrue()
                .andEq(SysUser::getUsername,user.getUsername())
                .andEq(SysUser::getPassword,user.getPassword())
                .limit(1)
        );

        //如果查到了则登录
        if (ObjUtil.isNotEmpty(sysUsers)) {
            StpUtil.login(sysUsers.getId());
            return StpUtil.getTokenInfo().getTokenValue();
        }else {
            throw new LoginException("账号或密码错误");
        }
    }


    /**
     * @param userId 用户id
     * @return 用户信息
     */
    @Override
    public SysUser info(String userId) {

        return sysUserBaseMapper.selectItem(mq->mq
                .whereTrue()
                .andEq(SysUser::getId,userId)
                .limit(1)
        );
    }
}
