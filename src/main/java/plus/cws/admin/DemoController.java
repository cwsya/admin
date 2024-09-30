package plus.cws.admin;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.wood.BaseMapper;
import org.noear.wood.DataList;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;
import java.sql.SQLException;

@Controller
public class DemoController {

    @Db
    DbContext db;


    @Mapping("/hello")
    public String hello(String name) throws SQLException {
        DataList dataList = db.sql("select * from sys_user").getDataList();
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