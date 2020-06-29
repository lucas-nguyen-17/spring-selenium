package com.giangtester.localhost.framework.pages;

import com.giangtester.localhost.framework.Browser;
import com.giangtester.localhost.framework.domain.Address;
import com.giangtester.localhost.framework.domain.CreditCard;
import com.giangtester.localhost.framework.domain.OtherInformation;

import static com.giangtester.localhost.framework.locators.CssSelector.CONFIRM;

public class ShoppingCartPage {

    private final BillingAddressForm billingAddressForm;
    private final CreditCardForm creditCardForm;
    private final OtherInformationForm otherInformationForm;
    private final Browser browser;

    public ShoppingCartPage(Browser browser) {
        this.browser = browser;
        this.otherInformationForm = new OtherInformationForm(browser);
        this.billingAddressForm = new BillingAddressForm(browser);
        this.creditCardForm = new CreditCardForm(browser);
    }

    public void setOtherInformation(OtherInformation otherInformation) {
        otherInformationForm.setOtherInformation(otherInformation);
    }

    public void setBillingAddress(Address address) {
        billingAddressForm.setBillingAddress(address);
    }

    public void setCreditCard(CreditCard card) {
        creditCardForm.setCreditCard(card);
    }

    public void confirm() {                 //<1>
        browser.click(CONFIRM);
    }
}