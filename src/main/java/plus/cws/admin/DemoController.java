package plus.cws.admin;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import plus.cws.admin.common.entity.R;
import plus.cws.admin.sys.cache.service.ICacheService;

import java.sql.SQLException;

@Controller
public class DemoController {

    @Inject
    private ICacheService cacheService;


    @Mapping("/hello")
    public R<?> hello(String name) throws SQLException, InterruptedException {
        cacheService.put(name, "hello", 1000);
        System.out.println(cacheService.get(name));
        Thread.sleep(1500);
        System.out.println(cacheService.get(name));
        return R.ok();
    }

//    @Db
//    DbContext db;
//
//    @Mapping("test")
//    public Object test() throws Throwable {
//        //只有 .table 接口和 .mapperBase 接口，有便捷分页功能
//        return db.table("appx")
//                .limit(0, 2)
//                .selectPage("*", Map.class);
//    }

}