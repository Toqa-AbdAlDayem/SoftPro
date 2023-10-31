Feature: Signup



  Scenario:  Successful Sign Up with Minimal Information
    Given  the user is on the registration page
   And they fill in the registration form with a valid username "toqa" and a strong password "123456toqa" and a correct email "toqaomar24@gmail.com" and a correct confim password "123456toqa"
    And they click the "Sign Up" button
   Then their account should be successfully created
    Then they should see the alert with message "Welcome home"
    And they should be redirected to the home page



  Scenario: Failed Sign up
    Given the user is on the registration page
    When they fill in the registration form with a valid username "new_user" and a strong password "123456toqa" and a correct confim password "123456toqa"
    And they leave the email
    And they click the "Sign Up" button
    Then they should see the alert with message "Email Required!"
    And they should remain on the registration page


  Scenario: username already exist
    Given the user is on the registration page
    When they fill in the registration form with an exists username "toqa"
    And they click the "Sign Up" button
    Then  Then they should see the alert with message "username is exist"
    And they should remain on the registration page

  Scenario: Password Confirmation Mismatch during Registration
    Given the user is on the registration page
    When they fill in the registration form with a valid username "new_user" and a strong password "SecurePassword123"
    And they confirm the password with a different value "MismatchedPassword456"
    Then  Then they should see the alert with message "MisMatch Password"
    And they should remain on the registration page
