package VOM.core;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static VOM.core.ApplicationManager.logger;

public class BaseHelper {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public BaseHelper(WebDriver driver, WebDriverWait wait) {
    this.driver = driver;
    this.wait = wait;
  }

  public boolean isElementPresent(By locator) {
     try {
      wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
      return true;
    } catch (TimeoutException e) {
      return false;
    }
  }

  public void type(By locator, String text) {
    if (text != null) {
      click(locator);
      driver.findElement(locator).clear();
      driver.findElement(locator).sendKeys(text);
    }
  }

  public void click(By locator) {
    try {

      wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    } catch (TimeoutException te) {

      System.out.println("Время ожидания элемента истекло: " + locator);
      throw te;
    } catch (WebDriverException e) {

      try {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        driver.findElement(locator).click();
      } catch (WebDriverException ex) {

        System.out.println("Не удалось кликнуть по элементу: " + locator);
        throw ex;
      }
    }
  }

  public boolean isAlertPresent() {
    Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
    if (alert == null) {
      return false;
    } else {
      driver.switchTo().alert().accept();
      return true;
    }
  }

  public String takeScreenshot() {
    File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    File screenshot = new File("screenshots/screen-" + System.currentTimeMillis() + ".png");
    try {
      Files.copy(tmp, screenshot);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    logger.info("Screenshot saved to: ["+ screenshot.getAbsolutePath()+"]");
    return screenshot.getAbsolutePath();
  }
}
