package geektime.spring.errorcodedemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
class ErrorcodeDemoApplicationTests {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void customErrorCodeTest() {
		jdbcTemplate.execute("insert into foo (id, bar) values (1, 'a')");
		jdbcTemplate.execute("insert into foo (id, bar) values (1, 'b')");
	}


}
