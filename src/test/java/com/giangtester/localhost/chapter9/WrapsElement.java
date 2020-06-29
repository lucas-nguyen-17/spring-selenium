package com.giangtester.localhost.chapter9;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.remote.RemoteWebElement;

public interface WrapsElement extends Locatable {
    WebElement getWrappedElement();

    default Coordinates getCoordinates() {
        return ((RemoteWebElement) getWrappedElement()).getCoordinates();
    }

  }
