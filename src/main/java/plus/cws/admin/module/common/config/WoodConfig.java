package plus.cws.admin.module.common.config;

import org.noear.solon.annotation.Component;
import org.noear.solon.core.event.AppLoadEndEvent;
import org.noear.solon.core.event.EventListener;

/**
 * Wood配置类
 */
@Component
public class WoodConfig implements EventListener<AppLoadEndEvent> {
    @Override
    public void onEvent(AppLoadEndEvent event) throws Throwable {
        //设置wood插件在调用selectItem方法时未查到返回null
        org.noear.wood.WoodConfig.isSelectItemEmptyAsNull=true;
    }
}