package geektime.spring.jedisdemo.repository;

import geektime.spring.jedisdemo.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
