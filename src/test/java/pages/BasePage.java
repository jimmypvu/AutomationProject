package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public BasePage(WebDriver givenDriver){
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
    }

    public void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public void click(WebElement locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public WebElement findElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void contextClick(By locator){
        action.click(findElement(locator)).perform();
    }

    public void contextClick(WebElement locator){
        action.click(locator).perform();
    }

    public void doubleClick(By locator){
        action.doubleClick(findElement(locator));
    }

    public void doubleClick(WebElement locator){
        action.doubleClick(locator).perform();
    }
}
