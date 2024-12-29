package plus.cws.admin;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;
import org.noear.solon.scheduling.annotation.EnableScheduling;
import org.noear.solon.web.cors.CrossFilter;
import org.noear.wood.WoodConfig;

@SolonMain
@EnableScheduling
public class App {



    public static void main(String[] args) {
        Solon.start(App.class, args,(app) -> {

            app.filter(-1, new CrossFilter().allowedOrigins("*"));

            if (Solon.cfg().isDebugMode() || Solon.cfg().isFilesMode()) {
                //执行后打印sql
                WoodConfig.onExecuteAft(cmd -> System.out.println("[Wood]" + cmd.text + "\r\n" + cmd.paramMap()));
            }
        });

        System.out.println("启动成功!-------------------");

    }
}