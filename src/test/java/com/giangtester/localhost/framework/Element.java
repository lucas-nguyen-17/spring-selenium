package com.giangtester.localhost.framework;

import org.openqa.selenium.WebElement;

public class Element extends DelegatingWebElement implements ExplicitWait {

    public Element(WebElement delegate) {
        super(delegate);
    }
}
