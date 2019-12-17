package com.ke.ning.spring.mybatis.demo.model;

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
 * @date 2019-12-17 09:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coffee {

    private Long id;
    private Money price;
    private String name;
    private Date createTime;
    private Date updateTime;
}
