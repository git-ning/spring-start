package geektime.spring.declarativetranstractiondemo;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-07 21:48
 */
public interface FooService {

    void insertRecord();

    void insertThenRollback() throws RollbackException;

    void invokeInsertThenRollback() throws RollbackException;
}
