package geektime.spring.complexcontrollerdemo.controller.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-05 15:21
 */
@Getter
@Setter
@ToString
public class NewOrderRequest {

    private String customer;
    private List<String> items;
}
