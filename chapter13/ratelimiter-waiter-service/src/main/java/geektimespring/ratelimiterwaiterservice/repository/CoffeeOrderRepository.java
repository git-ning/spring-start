package geektimespring.ratelimiterwaiterservice.repository;

import geektimespring.ratelimiterwaiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
