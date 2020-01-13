package geektime.spring.druiddemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-13 09:52
 */
@Repository
public class FooService {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public void selectForUpdate() {

        jdbcTemplate.queryForObject("select id from foo where id = 1 for update", Long.class);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
        }
    }
}
