package com.ke.ning.spring.mybatis.demo.mapper;

import com.ke.ning.spring.mybatis.demo.model.Coffee;
import org.apache.ibatis.annotations.*;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2019-12-17 09:26
 */
@Mapper
public interface CoffeeMapper {

    @Insert("insert into t_cofee (name, price, create_time, update_time) " +
            "values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("select * from t_cofee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime")
    })
    Coffee findById(@Param("id") Long id);
}
