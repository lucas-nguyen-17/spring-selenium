package com.giangtester.localhost.chapter7;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.support.AbstractTestExecutionListener;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.Files;

@Configuration
@PropertySource("classpath:application.properties")
public class ScreenshotTaker extends AbstractTestExecutionListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScreenshotTaker.class);

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
        if (isScreenshotEnabled()) {
            TakesScreenshot takesScreenshot = (TakesScreenshot) testContext.getApplicationContext()
                    .getBean(WebDriver.class);
            File screenshot = takesScreenshot.getScreenshotAs(OutputType.FILE);
            File dir = new File("target/screenshots");
            if (!dir.exists()) {
                Files.createDirectories(dir.toPath());
            }
            Method method = testContext.getTestMethod();
            File file = new File(dir, String.format("%s#%s.png", method.getDeclaringClass().getName(), method.getName()));
            FileUtils.deleteQuietly(file);
            FileUtils.moveFile(screenshot, file);
            LOGGER.info("saved screenshot as {}", file);
        }
    }

    private boolean isScreenshotEnabled() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScreenshotTaker.class);
        ConfigurableEnvironment environment = context.getEnvironment();
        return Boolean.parseBoolean(environment.getProperty("webdriver.screenshots.enabled"));
    }

}
