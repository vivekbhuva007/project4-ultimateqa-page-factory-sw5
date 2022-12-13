package com.ultimateqa.testsuite;

import com.ultimateqa.customerlisteners.CustomListeners;
import com.ultimateqa.pages.HomePage;
import com.ultimateqa.pages.LoginPage;
import com.ultimateqa.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginPage;
    HomePage  homePage;

    @BeforeMethod (alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
    }
    @Test (groups = {"sanity", "regression"})
    public void verifyTheErrorMessage() {
        loginPage.navigatedToLoginPage();
        loginPage.userName("vivek14@gmail.com");
        loginPage.passwordField("vivek123");
        loginPage.setSignInButton();
        String expectedMessage = "Invalid email or password.";
        Assert.assertEquals(loginPage.messageOccur(), expectedMessage, "Message not displayed");
        String expectedMessage1 = "Welcome Back!";
        Assert.assertEquals(loginPage.Message(), expectedMessage1, "Message not displayed");
    }
}


