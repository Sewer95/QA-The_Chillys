package Cucumber.pages;

import Cucumber.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
  public HomePage(WebDriver driver) {
    super(driver);
  }

  public HomePage openHomePage() {
    driver.get("https://urchin-app-jq2i7.ondigitalocean.app/#/");
    return new HomePage(driver);
  }

  @FindBy(xpath = "//h1[.='The Chillys Radio']")
  WebElement homePageTitle;

  public boolean isHomePageTitleDisplayed() {
    return isElementPresent(homePageTitle);
  }

  @FindBy(xpath = "//a[.='Login']")
  WebElement loginLink;

  public LoginPage clickOnLoginLink() {
    click(loginLink);
    return new LoginPage(driver);
  }
}
