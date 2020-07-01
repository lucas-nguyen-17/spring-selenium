package com.giangtester.localhost.framework.pages;

import com.giangtester.localhost.framework.Browser;
import com.giangtester.localhost.framework.domain.OtherInformation;

import static com.giangtester.localhost.framework.locators.Id.*;
import static com.giangtester.localhost.framework.locators.Name.MAILING_OPTION;

public class OtherInformationForm {

    private Browser browser;

    public OtherInformationForm(Browser browser) {
        this.browser = browser;
    }

    public void setOtherInformation(OtherInformation info) {
        browser.setInputText(COUPON_CODE, info.couponCode);
        browser.setInputText(BILLING_EMAIL, info.email);
        browser.setInputText(COMMENTS, info.comments);
        browser.setCheckboxValue(CONFIRM_EMAIL, info.sendOrdersToEmail);
        browser.setCheckboxValue(RATINGS, info.sendRatingEmail);
        browser.setRadio(MAILING_OPTION, info.mailingOption);
    }
}
