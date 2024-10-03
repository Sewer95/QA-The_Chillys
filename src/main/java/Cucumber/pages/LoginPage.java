package Cucumber.pages;

import Cucumber.core.BasePage;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

public class LoginPage extends BasePage {
  public LoginPage(WebDriver driver) {
    super(driver);
  }

 // @FindBy(id = "email")
  WebElement emailInput;

 // @FindBy(id = "password")
  WebElement passwordInput;

  public LoginPage enterCredentials(String email, String password) {
    type(emailInput, email);
    type(passwordInput, password);
    return this;
  }

//  @FindBy(xpath = "//button[.='Y’alla!']")
     WebElement loginButton;

  public LoginPage clickOnLoginButton() {
   click(loginButton);
    return this;
  }

//  @FindBy(className = "message")
 WebElement message;

  public LoginPage verifyTextMessage(String textToCheck) {
    pause(1000);
    assert message.getText().equals(textToCheck);
    return this;
  }

  public LoginPage enterInValidCredentials(DataTable table) {
    List<Map<String, String>> dataTable = table.asMaps(); // ["email", "password"]
    String email = dataTable.get(0).get("email");
    String password = dataTable.get(0).get("password");
    enterCredentials(email,password);
    return this;
  }
}
