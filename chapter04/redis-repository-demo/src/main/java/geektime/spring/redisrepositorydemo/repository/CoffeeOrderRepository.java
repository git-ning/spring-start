package geektime.spring.redisrepositorydemo.repository;

import geektime.spring.redisrepositorydemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
