package vom_tests;

import org.testng.Assert;
import org.testng.annotations.*;
import VOM.model.User;

public class LoginTests extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (!app.getUserHelper().isLoginLinkPresent()) {
      app.getUserHelper().clickOnSignOutButton();
    }
    app.driver.get("https://urchin-app-jq2i7.ondigitalocean.app/#/login");
  }

  @Test
  public void loginExistedUserPositiveTest() {
    app.getUserHelper().loginExistedUserPositive();
    app.getUserHelper().isSignOutButtonPresent();
  }

  @Test
  public void loginUserWitOutPasswordNegativeTest() {
    app.getUserHelper().clickLoginLink();
    app.getUserHelper().fillInRegistrationForm(new User().setUserName("TestUser"));
    app.getUserHelper().clickOnLoginButton();
    Assert.assertTrue(app.getUserHelper().isAlertPresent());
  }

}

