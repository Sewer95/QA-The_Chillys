package Cucumber.stepDefinitions;

import Cucumber.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static Cucumber.core.BasePage.driver;

public class HomePageSteps {

  @Given("User launches the browser")
  public void userLaunchesBrowser(){
    new HomePage(driver).launchBrowser();
  }

  @When("User opens home page The Chillys")
  public HomePage userOpensHomePage(){
    new HomePage(driver).openHomePage();
    return new HomePage(driver);
  }

  @Then("Check that the home page title is displayed")
  public HomePage verifyHomePageTitle(){
    Assert.assertTrue(new HomePage(driver).isHomePageTitleDisplayed());
    return new HomePage(driver);
  }

  @And("User closes browser")
  public void userQuiteBrowser() {
    new HomePage(driver).quitBrowser();
  }
}
