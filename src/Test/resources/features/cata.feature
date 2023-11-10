Feature: Accessory Information


  Scenario: User views interior car accessory categories
    Given the user is on the home page
    When the user clicks on the Interior Accessories button
    Then the user navigates to the "Interior Accessories" section


  Scenario: View information for Seat Cover
    Given the user is on the accessories page
    When the user clicks the Information button for  Seat Cover
    Then the user should see information about  Seat Cover
    When the user clicks the ShowLess button for  Seat Cover
    Then the user should see Seat Cover without information


  Scenario: View information for Floor Mate
    Given the user is on the accessories page
    When the user clicks the Information button for  Floor Mate
    Then the user should see information about   Floor Mate
    When the user clicks the ShowLess button for  Floor Mate
    Then the user should see Floor Mate without information

  Scenario: View information for Dashboard covers
    Given the user is on the accessories page
    When the user clicks the Information button for  Dashboard covers
    Then the user should see information about  Dashboard covers
    When the user clicks the ShowLess button for  Dashboard covers
    Then the user should see Dashboard covers without information

  Scenario: View information for Steering wheel covers
    Given the user is on the accessories page
    When the user clicks the Information button for Steering wheel covers
    Then the user should see information about Steering wheel covers
    When the user clicks the ShowLess button for Steering wheel covers
    Then the user should see Steering wheel covers without information