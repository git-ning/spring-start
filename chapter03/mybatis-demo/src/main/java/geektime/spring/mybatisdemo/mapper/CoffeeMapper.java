package geektime.spring.mybatisdemo.mapper;

import geektime.spring.mybatisdemo.model.Coffee;
import org.apache.ibatis.annotations.*;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-19 09:45
 */
@Mapper
public interface CoffeeMapper {

    @Insert("insert into t_coffee (name, price, create_time, update_time) values (#{name}, #{price}, now(), now())")
    @Options(useGeneratedKeys = true)
    int save(Coffee coffee);

    @Select("select * from t_coffee where id = #{id}")
    @Results({
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "create_time", property = "createTime"),
            @Result(column = "update_time", property = "updateTime")
    })
    Coffee findById(@Param("id") Long id);
}
