package geektime.spring.cachewithredisdemo.repository;

import geektime.spring.cachewithredisdemo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
