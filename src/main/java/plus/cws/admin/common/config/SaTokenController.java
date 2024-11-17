package plus.cws.admin.common.config;


import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.solon.integration.SaTokenFilter;
import cn.dev33.satoken.stp.StpUtil;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.core.handle.Filter;
import plus.cws.admin.common.entity.R;
import plus.cws.admin.common.entity.ResultCodeEnum;

/**
 * SaToken配置类 配置那些路径需要鉴权
 */
@Configuration
public class SaTokenController {

    @Bean
    public Filter saTokenFilter() {
        return new SaTokenFilter()
                .addInclude("/**")
                .setAuth(obj -> {
                    SaRouter
                            .match("/**")
                            .notMatch(
                                    "/auth/test",
                                    "/auth/login",
                                    "/auth/isLogin"

                            )
                            .check(r -> StpUtil.checkLogin());
                })
                .setError(e -> R.error(ResultCodeEnum.ERROR_AUTH));
    }

}
