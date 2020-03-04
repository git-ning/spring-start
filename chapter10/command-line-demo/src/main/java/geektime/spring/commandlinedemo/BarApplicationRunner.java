package geektime.spring.commandlinedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-25 09:08
 */
@Component
@Order(2)
@Slf4j
public class BarApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("bar");
    }
}
