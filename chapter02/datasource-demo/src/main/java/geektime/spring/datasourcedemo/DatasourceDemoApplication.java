package geektime.spring.datasourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class DatasourceDemoApplication implements CommandLineRunner {

	@Autowired
	DataSource dataSource;
	@Autowired
	JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DatasourceDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		showConnection();
		showDate();
	}

	private void showConnection() throws SQLException {

		log.info(dataSource.toString());
		Connection connection = dataSource.getConnection();
		log.info(connection.toString());
		connection.close();
	}

	private void showDate() {

		jdbcTemplate.queryForList("select * from foo").forEach(row -> log.info(row.toString()));
	}
}
