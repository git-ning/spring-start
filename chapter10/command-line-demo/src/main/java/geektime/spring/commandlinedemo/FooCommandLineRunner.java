package geektime.spring.commandlinedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-25 09:07
 */
@Component
@Order(1)
@Slf4j
public class FooCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("foo");
    }
}
