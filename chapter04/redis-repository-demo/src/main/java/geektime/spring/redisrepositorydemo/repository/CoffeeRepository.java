package geektime.spring.redisrepositorydemo.repository;

import geektime.spring.redisrepositorydemo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
