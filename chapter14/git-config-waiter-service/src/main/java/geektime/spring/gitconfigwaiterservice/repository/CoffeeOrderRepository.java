package geektime.spring.gitconfigwaiterservice.repository;

import geektime.spring.gitconfigwaiterservice.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
