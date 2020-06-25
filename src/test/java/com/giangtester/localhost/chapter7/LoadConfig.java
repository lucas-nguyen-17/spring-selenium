package com.giangtester.localhost.chapter7;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.URI;

@Configuration
@PropertySource("classpath:application.properties")
@Slf4j
public class LoadConfig {

    private final Config conf;

    public LoadConfig() {
        conf = ConfigFactory.load("application.conf");
    }

    private String testEnv() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(LoadConfig.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        log.info(String.valueOf(environment.getPropertySources()));
        return environment.getProperty("env", "qa");
    }

    private Config setEnv() {
        return conf.getConfig(testEnv());
    }

    public URI getBaseUrl() {
        return URI.create(setEnv().getString("baseURL"));
    }

    public String getName() {
        return setEnv().getString("account.admin");
    }

    public String getPassword() {
        return setEnv().getString("account.password");
    }
}
