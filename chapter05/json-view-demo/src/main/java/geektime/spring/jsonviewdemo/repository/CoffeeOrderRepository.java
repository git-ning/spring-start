package geektime.spring.jsonviewdemo.repository;

import geektime.spring.jsonviewdemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
