package geektime.spring.mybatispagehelperdemo;

import com.github.pagehelper.PageInfo;
import geektime.spring.mybatispagehelperdemo.mapper.CoffeeMapper;
import geektime.spring.mybatispagehelperdemo.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
@MapperScan("geektime.spring.mybatispagehelperdemo.mapper")
public class MybatisPagehelperDemoApplication implements ApplicationRunner {

	@Autowired
	private CoffeeMapper coffeeMapper;

	public static void main(String[] args) {
		SpringApplication.run(MybatisPagehelperDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		coffeeMapper.findAllWithRowBounds(new RowBounds(1, 3))
				.forEach(coffee -> log.info("page[1] coffee[{}]", coffee));
		coffeeMapper.findAllWithRowBounds(new RowBounds(2, 3))
				.forEach(coffee -> log.info("page[2] coffee[{}]", coffee));

		// 查找所有
		coffeeMapper.findAllWithRowBounds(new RowBounds(1, 0))
				.forEach(coffee -> log.info("page[1] coffee[{}]", coffee));

		coffeeMapper.findAllWithParam(1, 3)
				.forEach(coffee -> log.info("page[1] coffee[{}]", coffee));
		List<Coffee> list = coffeeMapper.findAllWithParam(2, 3);
		PageInfo pageInfo = new PageInfo(list);
		log.info("page info[{}]", pageInfo);
	}
}
