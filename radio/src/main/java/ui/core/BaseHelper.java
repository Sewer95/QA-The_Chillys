package ui.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseHelper {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public BaseHelper(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  protected void type(By locator, String text) {
    if (text != null) {
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }
  }

  protected void click(By locator) {
    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
  }
}
