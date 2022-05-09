package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistersuccessPage extends Utility {
    public void inIt(){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='result']")
    WebElement regSuccessFullField;

    public String getTextFromRegSuccesfull(){
        return  getTextFromElement(regSuccessFullField);
    }
}
