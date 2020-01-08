package geektime.spring.declarativetranstractiondemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@Slf4j
public class DeclarativeTranstractionDemoApplication implements CommandLineRunner {

	@Autowired
	private FooService fooService;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DeclarativeTranstractionDemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

		fooService.insertRecord();

		log.info("AAA: {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='AAA'", Long.class));

		try {
			fooService.insertThenRollback();
		} catch (RollbackException e) {
			log.info("BBB: {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='BBB'", Long.class));
		}

		try {
			fooService.invokeInsertThenRollback();
		} catch (RollbackException e) {
			log.info("BBB: {}", jdbcTemplate.queryForObject("select count(*) from foo where bar='BBB'", Long.class));
		}

	}
}
