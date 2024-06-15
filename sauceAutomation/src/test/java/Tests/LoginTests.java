package Tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.loginPage;


public class LoginTests {
    private WebDriver driver;
    private loginPage loginPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://www.saucedemo.com/");
        loginPage = new loginPage(driver);
    }

    @Test (priority = 1)
    public void elementsPresenceTest() {
        Assert.assertTrue(loginPage.isUsernameFieldPresent());
        Assert.assertTrue(loginPage.isPasswordFieldPresent());
        Assert.assertTrue(loginPage.isLoginButtonPresent());
    }

    @Test (priority = 2)
    public void validCredTest() {
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.isSwagLabsTitleVisible());
        Assert.assertTrue(loginPage.getSwagLabsTitle().contains("Swag Labs"));
    }


    @Test (priority = 3)
    public void invalidCredTest() {

        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("asdf");
        loginPage.enterPassword("asdf");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test (priority = 4)
    public void emptyUsernameTest() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Username is required"));
    }

    @Test (priority = 5)
    public void emptyPassTest() {
        driver.get("https://www.saucedemo.com/");
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();

        Assert.assertTrue(loginPage.getErrorMessage().contains("Epic sadface: Password is required"));
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

