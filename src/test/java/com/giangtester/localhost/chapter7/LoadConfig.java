package com.giangtester.localhost.chapter7;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import java.net.URI;

@Configuration
@PropertySource("classpath:application.properties")
@Slf4j
public class LoadConfig {

    private final Config conf;

    @Autowired
    private ConfigurableEnvironment environment;

    public LoadConfig() {
        conf = ConfigFactory.load("application.conf");
    }

    private String testEnv() {
        log.info(String.format("test environment is %s", environment.getProperty("env")));
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
