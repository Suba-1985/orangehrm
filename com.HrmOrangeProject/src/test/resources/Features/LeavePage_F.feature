

Feature: Leave approval

  @tag1
  Scenario: Applying for a Personal leave approval 
   
    Given User logins in to the OrangeHRM application with valid username and password
    When  User Navigates to Leave menu in the OrangeHRM application
    And   user clicks apply link leave screen in the application
    Then  User should be able to view assign leave screen in orange hrm application
    When  user selects personal leave in leave screen of orange hrm application
    Then  User able to view the leave balance in leave screen of orange hrm
    When  user selects from and to dates in leave screen of orange hrm application
    When  user enters comment as "Sick Leave" in leave screen in orange hrm application
    When  user clicks apply button in leave screen of orange hrm application
    Then  user is able to view success message in leave screen of orange hrm application

  
 
