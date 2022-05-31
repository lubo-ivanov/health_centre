package projects.healthcentre.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;

@Configuration
public class ApplicationBeanConfiguration {

    @Bean
public Validator validator() {
        return Validation.buildDefaultValidatorFactory().getValidator();
    }
}
