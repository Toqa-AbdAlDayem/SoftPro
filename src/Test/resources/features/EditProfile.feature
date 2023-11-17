Feature: User Profile


  Scenario: Edit Profile Information
    Given I am a logged-in customer
    When I navigate to the "editButton" section
    And I update my profile information with the following details:
      | Field            | New Value                   |
      | Name             | John Doe                    |
      | Email            | john.doe@example.com        |
      | Phone Number     | +1 555-555-5555             |
      | Shipping Address | 123 Main Street, City, USA  |
      | Vehicle Info     | Make: Toyota, Model: Camry, Year: 2020 |
    And I confirm the changes
    Then my profile information should be updated successfully

  Scenario: Cancel Editing Profile Information
    Given I am a logged-in customer
    When I navigate to the "editButton" section
    And I update my profile information with the following details:
      | Field            | New Value                   |
      | Name             | John Doe                    |
      | Email            | john.doe@example.com        |
      | Phone Number     | +1 555-555-5555             |
      | Shipping Address | 123 Main Street, City, USA  |
      | Vehicle Info     | Make: Toyota, Model: Camry, Year: 2020 |
    And I cancel the changes
    Then my profile information should not be updated


  Scenario: View Order History
    Given I am a logged-in customer
    When I click on "OrderHistory" button
    And I go to the "Order History" section
    Then I should see a list of my previous orders with the following details for each order:
      | Order Date     | Order Number | Items Purchased | Order Status | Total Cost | Tracking Info       |
      | 2023-10-20     | #12345       | Car Seat Covers  | Shipped     | $50.00     | USPS Tracking #123  |
      | 2023-10-15     | #12344       | Car Mats         | Delivered   | $30.00     | UPS Tracking #456   |
    And I can click on an order to view more details if needed

  Scenario: View Installation Requests
    Given I am a logged-in customer
    When I click on "InstallationRequests" button
    When I access the "Installation Requests" section
    Then I should see a list of my installation requests with the following details for each request:
      | Request Date  | Request Number | Requested Service       | Request Status | Appointment Details               |
      | 2023-10-25    | #78901         | Accessory Installation  | Pending       | Date: 2023-11-05, Time: 10:00 AM  |
      | 2023-10-18    | #78900         | Audio System Setup      | Approved      | Date: 2023-11-10, Time: 2:00 PM   |
    And I can reschedule or cancel an appointment if necessary

#  Scenario: Data Security
#    Given I am a logged-in customer
#    When I update my profile information
#    And I view my order history and installation requests
#    Then I expect my data to be kept secure and comply with data protection regulations


























#Feature:User Profile

 # Scenario: User edits personal information on the profile page

 #   Given the user is on the home page
 #   When the user clicks on the "Profile" button
 #   Then the user should be navigated to the profile page

#    Given the user is on the profile page
#    When the user views their personal information on the profile page
#    Then the user should see their:
#      | Field               | Value                      |
#      |---------------------|----------------------------|
#      | Name                | [User's current name]      |
#      | Email               | [User's current email]     |
#      | Address             | [User's current address]   |
#      | Phone Number        | [User's current phone number] |
#
#    When the user decides to edit their personal information
#    And the user chooses to edit the "Name" field
#    And the user enters the new value for the "Name" field as "[User's new name]"
#    And the user saves the changes
#    Then the user should see a confirmation message that the changes have been saved successfully
#
#    And when the user views their personal information again
#    Then the user should see their updated information:
#      | Field               | Value                      |
#      |---------------------|----------------------------|
#      | Name                | [User's new name]          |
#      | Email               | [User's current email]     |
#      | Address             | [User's current address]   |
#      | Phone Number        | [User's current phone number]  |
#
#    When the user decides to edit their personal information
#    And the user chooses to edit the "Email" field
#    And the user enters the new value for the "Email" field as "[User's new email]"
#    And the user saves the changes
#    Then the user should see a confirmation message that the changes have been saved successfully
#
#    And when the user views their personal information again
#    Then the user should see their updated information:
#      | Field               | Value                      |
#      |---------------------|----------------------------|
#      | Name                | [User's new name]          |
#      | Email               | [User's new email]         |
#      | Address             | [User's current address]   |
#      | Phone Number        | [User's current phone number]  |
#
#  Scenario: User views the history of installations
#    Given the user is on the home page
#    When the user clicks on the "History" button
#    Then the user should be navigated to the history page
#
#    When the user views the installation history
#    Then the user should see a list of installations with details:
#      | Installation Date       | Product           | Version   | Status       |
#      |-------------------------|-------------------|-----------|--------------|
#      | [Date1]                 | Product A         | v1.2.3    | Completed    |
#      | [Date2]                 | Product B         | v2.0.1    | In Progress  |
#      | [Date3]                 | Product C         | v1.5.0    | Failed       |
#
#    And the user should see a summary of installation statistics:
#      | Total Installations | Successful Installations | Failed Installations |
#      |---------------------|--------------------------|----------------------|
#      | [TotalCount]        | [SuccessCount]           | [FailedCount]        |