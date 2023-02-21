import com.google.auto.common.Visibility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest{
    @Test(enabled = true, priority = 0, description = "login with valid email / valid password")
    public static void loginValidEmailValidPassword(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("testemail@email.com", "password");
        loginPage.isUserLoggedIn();
    }

    @Test(enabled = true, dataProvider = "incorrectLoginProviders", dataProviderClass = BaseTest.class, priority = 0, description = "login with bad credentials")
    public static void loginInvalidCredentials(String badEmail, String badPassword){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(badEmail, badPassword);
        loginPage.isUserNotLoggedIn();
    }

}
