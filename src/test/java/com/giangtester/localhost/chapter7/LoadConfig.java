package com.giangtester.localhost.chapter7;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
public class LoadConfig {
    private Config conf;

    private LoadConfig() {
        conf = ConfigFactory.load("application.conf");
        String chosenEnv = System.getProperty("env");
        if (chosenEnv == null) {
            chosenEnv = "qa";
        }
        this.conf = conf.getConfig(chosenEnv);
    }

    public URI getBaseUrl(){
        return URI.create(conf.getString("baseURL"));
    }

    public String getName() {
        return conf.getString("account.admin");
    }

    public String getPassword() {
        return conf.getString("account.password");
    }
}
