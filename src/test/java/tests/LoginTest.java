package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import setup.Setup;

public class LoginTest extends Setup {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test(priority = 1, description = "Login with invalid user credentials")
    public void loginWithInvalidCredential() throws InterruptedException
    {
        // initialize login page object
        loginPage = new LoginPage(driver);
        // enter invalid user credentials
        loginPage.login("Admin","1234");

        String message_expected = "Invalid credentials";
        String message_actual = loginPage.getInvalidText();

        Assert.assertEquals(message_expected, message_actual);
        Thread.sleep(1500);
    }

    @Test(priority = 2, description = "Login with valid user credentials")
    public void loginWithValidCredential() throws InterruptedException
    {
        // initialize login page object
        loginPage = new LoginPage(driver);

        // initialize dashboard page object
        dashboardPage = new DashboardPage(driver);

        // enter valid user credentials
        loginPage.login("Admin","admin123");
        Thread.sleep(1500);

        Assert.assertEquals(dashboardPage.getHeaderTitle(), "Dashboard");
        Assert.assertTrue(dashboardPage.isUserDropDownVisible());
        Thread.sleep(1500);

        dashboardPage.logout();
    }

    @Test(priority = 3, description = "Login without entering username and password")
    public void loginWithoutUsernameAndPassword()
    {
        // initialize login page object
        loginPage = new LoginPage(driver);
        // enter invalid user credentials
        loginPage.clickLoginButton();

        String message_expected = "Required";
        String message_actual = loginPage.getRequiredInfoMessage();

        Assert.assertEquals(message_expected, message_actual);
    }


    @Test(priority = 4, description = "Login with empty password")
    public void loginWithEmptyPassword() throws InterruptedException
    {
        // initialize login page object
        loginPage = new LoginPage(driver);
        // enter invalid user credentials
        loginPage.login("Admin","");

        String message_expected = "Required";
        String message_actual = loginPage.getRequiredInfoMessage();

        Assert.assertEquals(message_expected, message_actual);
        Thread.sleep(1500);

        loginPage.clearUsername();
    }

    @Test(priority = 5, description = "Login with empty username")
    public void loginWithEmptyUsername() throws InterruptedException
    {
        // initialize login page object
        loginPage = new LoginPage(driver);
        // enter invalid user credentials
        loginPage.login("","admin123");

        String message_expected = "Required";
        String message_actual = loginPage.getRequiredInfoMessage();

        Assert.assertEquals(message_expected, message_actual);
    }
}
