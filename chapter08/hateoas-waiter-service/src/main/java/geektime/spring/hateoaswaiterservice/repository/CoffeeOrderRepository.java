package geektime.spring.hateoaswaiterservice.repository;

import geektime.spring.hateoaswaiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
