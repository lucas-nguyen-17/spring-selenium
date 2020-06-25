package com.giangtester.localhost.chapter5;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Path("/search.html")
@Verify(title = "Search")
@Component
public class SearchForm {

    @FindBy(name = "q")
    private WebElement textSearch;

    @FindBy(css = ".btn.btn-primary")
    private WebElement btnSubmit;

    public void searchFor(String query) {
        textSearch.sendKeys(query);
        btnSubmit.click();
    }

}
