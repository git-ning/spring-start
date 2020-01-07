package geektime.spring.simplejdbcdemo;

import lombok.Builder;
import lombok.Data;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-07 07:33
 */
@Data
@Builder
public class Foo {

    private Long id;
    private String bar;
}
