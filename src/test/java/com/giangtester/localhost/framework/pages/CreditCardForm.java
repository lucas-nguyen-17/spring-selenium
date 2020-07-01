package com.giangtester.localhost.framework.pages;


import com.giangtester.localhost.framework.Browser;
import com.giangtester.localhost.framework.domain.CreditCard;

import static com.giangtester.localhost.framework.locators.Id.*;

public class CreditCardForm {

    private Browser browser;

    public CreditCardForm(Browser browser) {
        this.browser = browser;
    }

    public void setCreditCard(CreditCard card) {
        browser.setInputText(CARD_NUMBER, card.cardNumber);
        browser.selectByVisibleText(CARD_TYPE, card.cardType);
        browser.selectByVisibleText(CARD_EXP_MONTH, card.expirationMonth);
        browser.selectByVisibleText(CARD_EXP_YEAR, card.expirationYear);
    }
}

