package geektime.spring.exceptiondemo.repository;

import geektime.spring.exceptiondemo.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
