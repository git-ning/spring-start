package geektime.spring.commandlinedemo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-25 09:14
 */
@Component
public class MyExitCodeGenerator implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        return 1;
    }
}
