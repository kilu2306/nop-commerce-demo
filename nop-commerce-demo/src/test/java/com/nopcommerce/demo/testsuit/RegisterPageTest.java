package com.nopcommerce.demo.testsuit;

import com.nopcommerce.demo.pages.HomePage;
import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.pages.RegistersuccessPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RegisterPageTest extends TestBase {
    HomePage homePage;
    RegisterPage registerPage;
    RegistersuccessPage registersuccessPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        registerPage = new RegisterPage();
        registersuccessPage = new RegistersuccessPage();

    }

    @Test(groups = {"smoke", "regression"})
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        homePage.clickOnRegisterLink();
        String actualText = registerPage.getTextFromRegisterFiled();
        String expactedText = "Register";
        Assert.assertEquals(actualText, expactedText, "displayed message is wrong");


    }

    @Test(groups = {"sanity", "regression"})
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        SoftAssert softAssert = new SoftAssert();

        homePage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        String actualFnameText = registerPage.geTextFromFNameErrorMessageField();
        String expactedFnameText = "First name is required.";
        softAssert.assertEquals(actualFnameText, expactedFnameText, "displayed Message is wrong");
        String actualLnameText = registerPage.geTextFromlNameErrorMessageField();
        String expactedLnameText = "Last name is required.";
        softAssert.assertEquals(actualLnameText, expactedLnameText, "displayed message is wrong");
        String actualEmailText = registerPage.geTextFromEmailErrorMessageField();
        String expactedEmailText = "Email is required.";
        softAssert.assertEquals(actualEmailText, expactedEmailText, "displayed message is wrong");
        String actualPassEwordText = registerPage.geTextFromPasswordErrorMessageField();
        String expactedPassWordtext = "Password is required.";
        softAssert.assertEquals(actualPassEwordText, expactedPassWordtext, "displayed message is wrong");

        softAssert.assertAll();

    }

    @Test(groups = {"regression"})
    public void verifyThatUserShouldCreateAccountSuccessfully() {
        homePage.clickOnRegisterLink();
        registerPage.clickOnFemaleRadioButton();
        registerPage.enterFirstName("dhyani");
        registerPage.enterLastName("patel");
        registerPage.selectDay("10");
        registerPage.selectMonth("January");
        registerPage.selectYear("1998");
        registerPage.enterEmail("dhyani444@gmail.com");
        registerPage.enterPassword("prime1234");
        registerPage.confirmPassword("prime1234");
        registerPage.clickOnRegisterButton();
        String actualtext = registersuccessPage.getTextFromRegSuccesfull();
        String expactedtext = "Your registration completed";
        Assert.assertEquals(actualtext, expactedtext, "displayed wrong message ");


    }


}
