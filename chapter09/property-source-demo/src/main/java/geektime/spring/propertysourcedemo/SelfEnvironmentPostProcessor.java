package geektime.spring.propertysourcedemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * TODO
 *
 * @author wangning040@ke.com
 * @date 2020-02-20 18:33
 */
@Slf4j
public class SelfEnvironmentPostProcessor implements EnvironmentPostProcessor {

    private PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {

        MutablePropertySources propertySources = environment.getPropertySources();
        Resource resource = new ClassPathResource("self.properties");
        try {
            PropertySource propertySource = loader.load("YetAnotherPropertiesFile", resource).get(0);
            propertySources.addFirst(propertySource);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
