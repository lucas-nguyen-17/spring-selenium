package com.giangtester.localhost.chapter7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:${env:qa}.properties")
public class TestEnvironment implements TestEnvironmentEnv {

    @Autowired
    private Environment environment;

    public String getName() {
        return environment.getProperty("account.admin");
    }

    public String getPassword() {
        return environment.getProperty("account.password");
    }

    public String getBaseUrl() {
        return environment.getProperty("baseURL");
    }
}
