package geektime.spring.contexthierarchydemo.context;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-05 08:18
 */
@AllArgsConstructor
@Slf4j
public class TestBean {

    private String context;

    public void hello() {
        log.info("hello " + context);
    }
}
