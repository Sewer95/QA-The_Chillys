package radio_tests.rest_assured;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import radio.dto.AuthRequestDto;
import radio.dto.AuthResponseDto;
import radio.dto.ErrorDto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends TestBase {
  AuthRequestDto requestDto = AuthRequestDto.builder()
      .name("admin")
      .password("qwerty")
      .build();


  @Test
  public void loginSuccessTest2(){
    String responseToken = given()
        .contentType(ContentType.JSON)
        .body(requestDto)
        .when()
        .post("/auth/login")
        .then()
        .assertThat().statusCode(200)
        .body(containsString("accessToken"))
        .extract().path("accessToken");
    System.out.println(responseToken);
  }

  @Test
  public void loginWithWrongPasswordTest(){
    ErrorDto errorDto = given()
        .body(AuthRequestDto.builder()
            .name("user_admin_new3@gmail.com")
            .password("Password@@@@@@@@@1")
            .build())
        .contentType(ContentType.JSON)
        .when()
        .post("/auth/login")
        .then()
        .assertThat().statusCode(401)
        .extract().response().as(ErrorDto.class);
//    System.out.println(errorDto);
//    System.out.println(errorDto.getMessage());
//    System.out.println(errorDto.getError());
//    System.out.println(errorDto.getTimestamp());
//    System.out.println(errorDto.getPath());
//    System.out.println(errorDto.getStatus());
    //Assert.assertEquals(errorDto.getError(),"Unauthorized");
    //Assert.assertEquals(errorDto.getMessage(),"Login or Password incorrect");
  }

  @Test
  public void loginWithWrongPasswordPerfectTest() {
    given()
        .body(AuthRequestDto.builder()
            .name("user_admin_new3@gmail.com")
            .password("Password@@@@@@@@@1")
            .build())
        .contentType(ContentType.JSON)
        .when()
        .post("/auth/login")
        .then()
        .assertThat().statusCode(401)
        .assertThat().body("error", equalTo("Unauthorized"))
        .assertThat().body("error", containsString("Unauth"));
  }
}
