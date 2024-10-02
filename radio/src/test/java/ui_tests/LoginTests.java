package ui_tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.data.UserData;
import ui.model.User;
import ui.fw.LoginHelper;
import ui_tests.TestBase;

public class LoginTests extends TestBase {

  @Test
  public void loginWithValidCredentials() {
    LoginHelper loginHelper = new LoginHelper(app.driver, app.wait);
    User user = new User()
            .setEmail(UserData.EMAIL)
            .setPassword(UserData.PASSWORD);

    loginHelper.login(user);
    Assert.assertTrue(loginHelper.isLoginSuccessful(), "Login was not successful");
  }
}
