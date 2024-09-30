package plus.cws.admin;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.wood.DbContext;
import org.noear.wood.WoodConfig;
import org.noear.wood.annotation.Db;

@SolonMain
public class App {



    public static void main(String[] args) {
        Solon.start(App.class, args,(app) -> {
            if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
                //执行后打印sql
                WoodConfig.onExecuteAft(cmd -> {
                    System.out.println("[Wood]" + cmd.text + "\r\n" + cmd.paramMap());
                });
            }
        });

    }
}