package geektime.spring.mybatispagehelperdemo.mapper;

import geektime.spring.mybatispagehelperdemo.model.Coffee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-27 08:48
 */
@Mapper
public interface CoffeeMapper {

    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from t_coffee order by id")
    List<Coffee> findAllWithParam(@Param("pageNum") int pageNum, @Param("pageSize") int pageSize);
}
