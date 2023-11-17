Feature: Appointment or Buy online

  Scenario: User Takes an Appointment Successfully
    Given the user is on the chosen page
    When the user clicks on the "Add Appointment" button
    Then a dialog box should appear
    And the user selects "Sunday" and "12-1" and "Paint the Car"
    And the user submits the appointment request
    Then the request should be saved successfully


  Scenario: User decides to Buy online
    Given the user is on the chosen page
    When the user clicks on the "Buy online" button1
    Then the user should be on the home page
