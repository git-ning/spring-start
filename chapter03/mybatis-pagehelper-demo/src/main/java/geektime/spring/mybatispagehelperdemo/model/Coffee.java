package geektime.spring.mybatispagehelperdemo.model;

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
 * @date 2020-01-27 08:47
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coffee {

    private Long id;
    private String name;
    private Money price;
    private Date createTime;
    private Date updateTime;
}
