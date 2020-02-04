package geektime.spring.mongorepositorydemo.repository;

import geektime.spring.mongorepositorydemo.model.Coffee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-03 14:22
 */
public interface CoffeeRepository extends MongoRepository<Coffee, String> {

    List<Coffee> findByName(String name);
}
