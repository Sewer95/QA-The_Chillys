package VOM.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import VOM.core.BaseHelper;

public class HomeHelper extends BaseHelper {

  public HomeHelper(WebDriver driver, WebDriverWait wait) {
    super(driver,wait);
  }

  public boolean isHomeComponentPresent(){
    return isElementPresent(By.xpath("//h1[.='The Chillys Radio']"));
  }

  public void clickOnHomeLink() {
    click(By.xpath("////img[@aria-label='Home']"));
  }
}
