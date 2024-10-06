package VOM.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import VOM.core.BaseHelper;
import VOM.data.UserData;
import VOM.model.User;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void loginExistedUserPositive() {
        clickLoginLink();
        fillInLoginForm(new User()
               .setName(UserData.NAME)
               .setPassword(UserData.PASSWORD));
        clickOnLoginButton();
    }

    public void fillInLoginForm(User user) {
        type(By.name("name"), user.getName());
        type(By.name("password"), user.getPassword());
    }
    public void fillInRegistrationForm(User user) {
        type(By.name("name"), user.getName());
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.xpath("//button[.='send form']"));
    }

    public void clickLoginLink() {
        click(By.xpath("//a[.='Login']"));
    }
    public void clickRegisterLink() {
        click(By.xpath("//a[.='Register']"));
    }

    public void isLogOutButtonPresent() {
        Assert.assertTrue(isElementPresent(By.xpath("//button[text()='Logout']")));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.xpath("//a[.='Login']"));
    }

    public void clickOnLogOutButton() {
        click(By.xpath("//button[text()='Logout']"));
    }
}
