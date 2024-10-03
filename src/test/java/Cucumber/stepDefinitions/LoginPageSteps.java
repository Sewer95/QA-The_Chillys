package Cucumber.stepDefinitions;

import Cucumber.pages.HomePage;
import Cucumber.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static Cucumber.core.BasePage.driver;

public class LoginPageSteps {
  @And("User clicks on Login link")
  public void userClicksOnLoginLink() {
    new HomePage(driver).clickOnLoginLink();
  }

  @And("User enters valid data")
  public void userEntersValidCredentials() {
    new LoginPage(driver).enterCredentials("testUser@gmail.com", "passwordTest01");
  }

  @And("User clicks on the Login button")
  public void userClickedOnLoginButton() {
    new LoginPage(driver).clickOnLoginButton();
  }

  @Then("User checks the display of a successful login message")
  public void userVerifySuccessfulLoginMessage() {
    new LoginPage(driver).verifyTextMessage("Logged in success");
  }

  @And("User enters valid email and invalid password")
  public void userEntersValidEmailInvalidPassword(DataTable table) {
    new LoginPage(driver).enterInValidCredentials(table);
  }

  @Then("User checks the display of an unsuccessful login message")
  public void userChecksErrorMessage() {
    new LoginPage(driver).verifyTextMessage("\"Login or Password incorrect\"");
  }
}
