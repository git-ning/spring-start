package geektime.spring.cachedemo;

import geektime.spring.cachedemo.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring 缓存抽象
 * 使用 spring 内置的缓存
 *
 */
@SpringBootApplication
@Slf4j
@EnableTransactionManagement
@EnableJpaRepositories
@EnableCaching(proxyTargetClass = true)
public class CacheDemoApplication implements ApplicationRunner {

	@Autowired
	private CoffeeService coffeeService;

	public static void main(String[] args) {
		SpringApplication.run(CacheDemoApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		log.info("count coffee[{}]", coffeeService.findAllCoffee().size());
		for (int i = 0; i < 10; i++) {
			log.info("reading from cache");
			coffeeService.findAllCoffee();
		}

		coffeeService.reloadCoffee();
		log.info("reading after refresh");
		log.info("reading after refresh");
		coffeeService.findAllCoffee().forEach(coffee -> log.info("coffee[{}]", coffee.getName()));
	}
}
