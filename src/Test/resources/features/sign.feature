Feature: Signup



  Scenario:  Successful Sign Up with Minimal Information
    Given  the user is on the registration page
    And they fill in the registration form with a valid username "eman" and a strong password "secure123ahmad" and a correct confirmpass "secure123ahmad" and a correct email "ahmadomar24@gmail.com" and Birthdate "1999-2-1" and Gender "Male"
    And they click the "Sign Up" button
   Then their account should be successfully created
    And they should be redirected to the home page


  Scenario: username already exist
    Given the user is on the registration page
    When they fill in the registration form with an exists username "toqa"
    And they click the "Sign Up" button
    Then  Then they should see the alert with message "username is exist"
    And they should remain on the registration page

  Scenario: Password Confirmation Mismatch during Registration
    Given the user is on the registration page
    When they fill in the registration form with a valid username "new_user" and a strong password "SecurePassword123" and they confirm the password with a different value "MismatchedPassword456"
    Then  Then they should see the alert with message "MisMatch Password"
    And they should remain on the registration page
