package geektime.spring.contexthierarchydemo.foo;

import geektime.spring.contexthierarchydemo.context.TestBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-05 08:32
 */
@Configuration
@EnableAspectJAutoProxy
public class FooConfig {

    @Bean
    public TestBean testBeanX() {
        return new TestBean("foo");
    }

    @Bean
    public TestBean testBeanY() {
        return new TestBean("foo");
    }

    @Bean
    public FooAspect fooAspect() {
        return new FooAspect();
    }
}
