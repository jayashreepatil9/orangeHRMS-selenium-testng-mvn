package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
    @FindBy(className="oxd-topbar-header-title")
    WebElement headerTitle;
    @FindBy(className = "oxd-userdropdown-tab")
    public WebElement btnProfileTab;
    @FindBy(partialLinkText = "Logout")
    public WebElement logOutLink;

    public DashboardPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getHeaderTitle() {
        return (headerTitle.getText());
    }

    public boolean isUserDropDownVisible(){
        return (btnProfileTab.isDisplayed());
    }

    public void logout() {
        btnProfileTab.click();
        logOutLink.click();
    }
}
