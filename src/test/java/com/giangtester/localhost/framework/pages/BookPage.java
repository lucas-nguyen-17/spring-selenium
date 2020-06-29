package com.giangtester.localhost.framework.pages;


import com.giangtester.localhost.framework.Browser;

import static com.giangtester.localhost.framework.locators.ClassName.CART_BUTTON;
import static com.giangtester.localhost.framework.locators.Id.TOP_NAV;
import static com.giangtester.localhost.framework.locators.TagName.INPUT;

public class BookPage {

    private Browser browser;

    public BookPage(Browser browser) {
        this.browser = browser;
    }

    public void addToCart() {
        browser.findElements(INPUT)
            .filter(e -> e.getValue().equals("add to cart"))
            .findFirst()
            .get()
            .click();
    }

    public void gotoCart() {
        browser.await(TOP_NAV).click(CART_BUTTON);
    }

}