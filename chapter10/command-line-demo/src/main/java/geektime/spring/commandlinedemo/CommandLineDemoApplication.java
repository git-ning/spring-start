package geektime.spring.commandlinedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CommandLineDemoApplication {

    public static void main(String[] args) {
        // 1. 代码来禁用 WEB
        new SpringApplicationBuilder(CommandLineDemoApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 2. 配置文件来禁用 WEB
//        SpringApplication.run(CommandLineDemoApplication.class, args);
    }

}
