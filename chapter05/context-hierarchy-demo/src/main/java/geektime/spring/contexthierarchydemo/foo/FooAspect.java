package geektime.spring.contexthierarchydemo.foo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-05 08:19
 */
@Aspect
@Slf4j
public class FooAspect {

    @AfterReturning("bean(testBean*)")
    public void printAfter() {
        log.info("after hello()");
    }
}
