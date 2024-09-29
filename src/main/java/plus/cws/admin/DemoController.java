package plus.cws.admin;

import com.zaxxer.hikari.HikariDataSource;
import org.noear.solon.annotation.Component;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Param;
import org.noear.wood.BaseMapper;
import org.noear.wood.DataList;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

import java.sql.SQLException;
import java.util.Map;

@Controller
public class DemoController {

    @Db
    DbContext db;

    @Db
    BaseMapper baseMapper;

    @Mapping("/hello")
    public String hello(String name) throws SQLException {
        DataList dataList = db.sql("select * from dict_equipment_archives order by add_time desc").getDataList();
        System.out.println(dataList.getMapList().toString());



        return String.format("Hello %s!", name);
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