package geektime.spring.declarativetranstractiondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 通过 fooService.insertThenRollback();
 * 实现了事务的回滚
 *
 * @author wangning040@ke.com
 * @date 2020-01-07 21:52
 */
@Component
public class FooServiceImpl implements FooService {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private FooService fooService;

    @Override
    @Transactional
    public void insertRecord() {

        jdbcTemplate.execute("insert into foo(bar) values ('AAA') ");
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback() throws RollbackException {

        jdbcTemplate.execute("insert into foo(bar) values ('BBB')");
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback() throws RollbackException {

        // 原来的
//      insertThenRollback();
        fooService.insertThenRollback();
    }
}
