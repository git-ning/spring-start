package geektime.spring.errorcodedemo;

import org.springframework.dao.DuplicateKeyException;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-01-08 09:38
 */
public class CustomDuplicatedKeyException extends DuplicateKeyException {

    public CustomDuplicatedKeyException(String msg) {
        super(msg);
    }

    public CustomDuplicatedKeyException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
