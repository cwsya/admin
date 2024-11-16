package plus.cws.admin.module.sys.auth.service;

import plus.cws.admin.module.common.entity.dao.SysUser;

public interface IAuthService {


    /**
     * 根据用户名密码登录
     * @param user
     * @return
     */
    String loginByPassword(SysUser user);

}
