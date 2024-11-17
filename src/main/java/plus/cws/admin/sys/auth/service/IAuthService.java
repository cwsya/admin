package plus.cws.admin.sys.auth.service;

import plus.cws.admin.common.entity.dao.SysUser;

public interface IAuthService {


    /**
     * 根据用户名密码登录
     * @param user
     * @return
     */
    String loginByPassword(SysUser user);

}
