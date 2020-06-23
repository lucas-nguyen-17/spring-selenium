package com.giangtester.localhost.chapter7;

import org.springframework.stereotype.Component;

@Component
public class EnvConfigFactory {

    public TestEnvironmentEnv get(String environment) {
        switch (environment) {
            case "staging":
                return new StagingConfig();
            case "qa":
                return new QAConfig();
            default:
                throw new IllegalStateException("unknown environment");
        }
    }
}
