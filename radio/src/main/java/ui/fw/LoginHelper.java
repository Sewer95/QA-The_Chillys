package ui.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.core.BaseHelper;
import ui.model.User;

public class LoginHelper extends BaseHelper {
  public LoginHelper(WebDriver driver, WebDriverWait wait) {
    super(driver, wait);
  }

  public void login(User user) {
    type(By.xpath("//input[@placeholder='login']"), user.getEmail());
    type(By.xpath("//input[@placeholder='password']"), user.getPassword());
    click(By.xpath("//button[@type='submit']"));
  }

  public boolean isLoginSuccessful() {
    return driver.findElement(By.xpath("//a[normalize-space(text())='Login/Register']")).isDisplayed();
  }
}
