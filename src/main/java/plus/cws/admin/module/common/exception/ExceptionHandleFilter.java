package plus.cws.admin.module.common.exception;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.Filter;
import org.noear.solon.core.handle.FilterChain;
import plus.cws.admin.module.common.entity.R;
import plus.cws.admin.module.common.entity.ResultCodeEnum;

@Component
public class ExceptionHandleFilter implements Filter {
    /**
     * @param ctx
     * @param chain
     * @throws Throwable
     */
    @Override
    public void doFilter(Context ctx, FilterChain chain) throws Throwable {

        try {
            chain.doFilter(ctx);
        } catch (LoginException e){
            ctx.render(R.error(ResultCodeEnum.ERROR_LOGIN, e.getMessage()));
        } catch (Throwable e) {
            ctx.render(R.error(ResultCodeEnum.ERROR, e.getMessage()));
        }
    }
}
