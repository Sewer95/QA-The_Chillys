package vom_tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateAccountTests extends TestBase {
  @BeforeMethod
  public void ensurePrecondition(){
    if (!app.getUserHelper().isLoginLinkPresent()) {
      app.getUserHelper().clickOnLogOutButton();
    }
  }



  @Test
  public void createAccountPositiveTestRefactor() {
    app.getUserHelper().clickRegisterLink();
    app.getUserHelper().type(By.name("name"),"TestUser555");
    app.getUserHelper().type(By.name("email"),"testUser@gmail.com");
    app.getUserHelper().type(By.name("password"),"passwordTest01");
    app.getUserHelper().click(By.xpath("//button[.='register']"));
    app.getUserHelper().isLogOutButtonPresent();
  }

  @Test
  public void createExistedAccountNegativeTest() {
    SoftAssert softAssert = new SoftAssert();
    app.getUserHelper().clickRegisterLink();
    app.getUserHelper().type(By.name("name"),"TestUser");
    app.getUserHelper().type(By.name("email"),"testUser@gmail.com");
    app.getUserHelper().type(By.name("password"),"passwordTest01");
    app.getUserHelper().click(By.xpath("//button[.='register']"));


    softAssert.assertTrue(app.getUserHelper().isAlertPresent());
    softAssert.assertTrue(app.getUserHelper().isElementPresent(By.xpath("//div[.='Registration failed with code 409']")));
    softAssert.assertAll();

  }
}
