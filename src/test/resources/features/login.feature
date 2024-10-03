Feature: Login

  @Login
  Scenario: Successful user login
    Given User launches the browser
    When User opens home page The Chillys
    And User clicks on Login link
    And User enters valid data
    And User clicks on the Login button
    Then User checks the display of a successful login message
    And User closes browser

  @InvalidPassword
  Scenario Outline: Unsuccessful user login
    Given User launches the browser
    When User opens home page The Chillys
    And User clicks on Login link
    And User enters valid email and invalid password
      | email   | password   |
      | <email> | <password> |
    And User clicks on the Login button
    Then User checks the display of an unsuccessful login message
    And User closes browser
    Examples:
      | email              | password        |
      | testUser@gmail.com | password_Test01 |
      | testUser@gmail.com | password@Test   |
      | testUser@gmail.com | Password01      |
      | testUser@gmail.com | PasswordTest111 |
