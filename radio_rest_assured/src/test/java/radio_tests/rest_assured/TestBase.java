package radio_tests.rest_assured;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeMethod;

public class TestBase {

  protected final String TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImV4cCI6MTcyODQ2MTg5NCwicm9sZXMiOlt7ImlkIjoxLCJ0aXRsZSI6IlJPTEVfVVNFUiIsImF1dGhvcml0eSI6IlJPTEVfVVNFUiJ9LHsiaWQiOjIsInRpdGxlIjoiUk9MRV9BRE1JTiIsImF1dGhvcml0eSI6IlJPTEVfQURNSU4ifV0sIm5hbWUiOiJhZG1pbiJ9.Usi6qI7y_gKEFznVojMksMIy_n_GpareDzv8znUa0mo";
  protected final String AUTH = "Authorization";

  @BeforeMethod
  public void init(){
    RestAssured.baseURI = "https://urchin-app-jq2i7.ondigitalocean.app";
    RestAssured.basePath = "api";
  }
}
