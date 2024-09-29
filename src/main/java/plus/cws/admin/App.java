package plus.cws.admin;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.wood.DbContext;
import org.noear.wood.annotation.Db;

@SolonMain
public class App {



    public static void main(String[] args) {
        Solon.start(App.class, args);
    }
}