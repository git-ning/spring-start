package geektime.spring.simplejdbcdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-07 07:34
 */
@Slf4j
@Repository
public class FooDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public void insertData() {

        Arrays.asList("b", "c").forEach(bar ->
        {jdbcTemplate.update("insert into foo (bar) values (?)", bar);});

        HashMap<String, String> row = new HashMap<>();
        row.put("bar", "d");
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        log.info("id of d: {}", id.longValue());
    }

    public void listData() {

        log.info("count: {}", jdbcTemplate.queryForObject("select count(*) from foo", Long.class));

        List<String> list = jdbcTemplate.queryForList("select bar from foo", String.class);
        list.forEach(bar -> log.info("bar: {}", bar));

        List<Foo> fooList = jdbcTemplate.query("select * from foo", new RowMapper<Foo>() {
            @Override
            public Foo mapRow(ResultSet rs, int rowNum) throws SQLException {
                return Foo.builder()
                        .id(rs.getLong(1))
                        .bar(rs.getString(2))
                        .build();
            }
        });
        fooList.forEach(foo -> log.info("foo: {}", foo));
    }
}
