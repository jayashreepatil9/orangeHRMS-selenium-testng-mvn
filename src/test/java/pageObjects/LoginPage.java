package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(name="username")
    WebElement txtBoxUsername;
    @FindBy(name="password")
    WebElement txtBoxPassword;
    @FindBy(xpath="//button[@type='submit']")
    WebElement loginBtn;
    @FindBy(xpath="//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")
    WebElement InvalidMessage;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']")
    WebElement requiredInfoMessage;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    public void login(String username, String password) throws InterruptedException {
        txtBoxUsername.sendKeys(username);
        txtBoxPassword.sendKeys(password);
        loginBtn.click();
    }
    public void clickLoginButton(){
        loginBtn.click();
    }
    public String getInvalidText() {
        return (InvalidMessage.getText());
    }
    public String getRequiredInfoMessage() {
        return (requiredInfoMessage.getText());
    }
    public void clearUsername(){
        txtBoxUsername.sendKeys(Keys.COMMAND, Keys.chord("a"));
        txtBoxUsername.sendKeys(Keys.BACK_SPACE);
    }
}
