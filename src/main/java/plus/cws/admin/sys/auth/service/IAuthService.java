package plus.cws.admin.sys.auth.service;

import plus.cws.admin.common.entity.dao.SysUser;

public interface IAuthService {


    /**
     * 根据用户名密码登录
     * @param user 用户信息
     * @return token
     */
    String loginByPassword(SysUser user);


    /**
     * 根据用户id获取用户信息
     * @param userId 用户id
     * @return 用户信息
     */
    SysUser info(String userId);

}
