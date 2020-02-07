package geektime.spring.complexcontrollerdemo.repository;

import geektime.spring.complexcontrollerdemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
