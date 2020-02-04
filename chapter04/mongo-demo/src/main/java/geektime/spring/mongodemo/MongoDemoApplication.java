package geektime.spring.mongodemo;

import com.mongodb.client.result.UpdateResult;
import geektime.spring.mongodemo.converter.MoneyReadConverter;
import geektime.spring.mongodemo.model.Coffee;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@SpringBootApplication
@Slf4j
public class MongoDemoApplication implements ApplicationRunner {

	@Autowired
	private MongoTemplate mongoTemplate;

	public static void main(String[] args) {
		SpringApplication.run(MongoDemoApplication.class, args);
	}

	@Bean
	public MongoCustomConversions mongoCustomConversions() {
		return new MongoCustomConversions(Arrays.asList(new MoneyReadConverter()));
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Coffee espresso = Coffee.builder()
				.name("espresso").price(Money.of(CurrencyUnit.of("CNY"), 20.00))
				.createTime(new Date())
				.updateTime(new Date())
				.build();
		// 保存
		Coffee coffee = mongoTemplate.save(espresso);
		log.info("coffee[{}]", coffee);

		// 查找
		List<Coffee> list = mongoTemplate.find(Query.query(Criteria.where("name").is("espresso")), Coffee.class);
		log.info("coffee size[{}]", list.size());
		list.forEach(c -> log.info("coffee[{}]", c));

		// 为了看更新时间
		Thread.sleep(1000);
		UpdateResult result = mongoTemplate.updateFirst(query(where("name").is("espresso")),
				new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 30))
						.currentDate("updateTime"),
				Coffee.class);
		log.info("Update Result[{}]", result.getModifiedCount());
		Coffee updateOne = mongoTemplate.findById(coffee.getId(), Coffee.class);
		log.info("Update Result[{}]", updateOne);

		mongoTemplate.remove(updateOne);
	}
}
