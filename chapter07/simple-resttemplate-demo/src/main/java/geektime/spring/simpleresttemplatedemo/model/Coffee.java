package geektime.spring.simpleresttemplatedemo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.money.Money;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {
    private Long id;
    private String name;
//    private BigDecimal price; // 先用BigDecimal，下次换Money
    private Money price;
    private Date createTime;
    private Date updateTime;
}
