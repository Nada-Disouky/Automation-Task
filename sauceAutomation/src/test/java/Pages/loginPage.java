package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class loginPage {
    WebDriver driver;
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMsg = By.cssSelector("div.error-message-container.error");
    private By swagLabsTitle = By.className("app_logo");


    public loginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isUsernameFieldPresent() {
        return driver.findElement(usernameField).isDisplayed();
    }

    public boolean isPasswordFieldPresent() {return driver.findElement(passwordField).isDisplayed();}

    public boolean isLoginButtonPresent() {
        return driver.findElement(loginButton).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }

    public boolean isSwagLabsTitleVisible() {
        return driver.findElement(swagLabsTitle).isDisplayed();
    }

    public String getSwagLabsTitle() {
        return driver.findElement(swagLabsTitle).getText();
    }
}
