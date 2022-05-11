package com.nopcommerce.demo.pages;

import com.nopcommerce.demo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInHomePage extends Utility {
    public LogInHomePage (){
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@class='ico-logout']")
    WebElement logoutLink;


public boolean logOutButonDisplayed(){
    return logoutLink.isDisplayed();
}
public void clickOnLogOut(){
    clickOnElement(logoutLink);
}
}
