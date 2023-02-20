package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage{
    By emailField = By.cssSelector("#username");
    By passwordField = By.cssSelector("#password");
    By rememberMeBox = By.cssSelector("input.form-check-input");
    By loginButton = By.cssSelector("#log-in");

    public LoginPage(WebDriver givenDriver){
        super(givenDriver);
    }

    public LoginPage provideEmail(String email){
        WebElement emailElement = findElement(emailField);
        action.click(emailElement).sendKeys(email).perform();
        return this;
    }

    public LoginPage providePassword(String password){
        WebElement passwordElement = findElement(passwordField);
        action.click(passwordElement).sendKeys(password).perform();
        return this;
    }

    public LoginPage checkRememberBox(){
        WebElement checkboxElement = findElement(rememberMeBox);
        checkboxElement.click();
        return this;
    }

    public LoginPage clickSubmitButton(){
        WebElement loginElement = findElement(loginButton);
        loginElement.click();
        return this;
    }

    public LoginPage login(String email, String password){
        provideEmail(email);
        providePassword(password);
        checkRememberBox();
        clickSubmitButton();
        return this;
    }

    public void isUserLoggedIn(){
        Assert.assertTrue(wait.until(ExpectedConditions.urlMatches("https://demo.applitools.com/app.html")));
    }

    public void isUserNotLoggedIn(){
        Assert.assertFalse(wait.until(ExpectedConditions.urlMatches("https://demo.applitools.com/app.html")));
    }
}
