package geektime.spring.mybatisdemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.util.Date;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-19 09:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee {

    private Long id;
    private String name;
    private Money price;

    private Date createTime;
    private Date updateTime;
}
