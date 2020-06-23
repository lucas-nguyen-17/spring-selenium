package com.giangtester.localhost.chapter7;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:staging.properties")
public class StagingConfig implements TestEnvironmentEnv {

    @Value("${account.admin}")
    private String name;

    @Value("${account.password}")
    private String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}
