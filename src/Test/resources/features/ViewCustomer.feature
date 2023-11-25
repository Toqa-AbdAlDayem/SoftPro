Feature: Admin Dashboard - View and Manage Customer Accounts

  Scenario: Admin views customer accounts
    Given the Admin is logged in
    When the Admin navigates to the "View Customers" section
    Then the Admin should see a list of customer accounts

  Scenario: Admin chose a customer account to show details
    Given the Admin is logged in
    When the Admin navigates to the "View Customers" section
    And selects a customer account to "View Details"
    Then the customer details should be displayed successfully

  Scenario: Admin deactivates a customer account
    Given the Admin is logged in
    When the Admin navigates to the "View Customers" section
    And selects a customer account to "deactivate"
    And confirms the "deactivation"
    Then the customer account should be deactivated successfully

  Scenario: Admin deactivates a customer account
    Given the Admin is logged in
    When the Admin navigates to the "View Customers" section
    And selects a customer account to "deactivate"
    And cancel the "deactivation"
    Then the customer account should be deactivated successfully

  Scenario: Admin deactivates a customer account
    Given the Admin is logged in
    When the Admin navigates to the "View Customers" section
    And selects a customer account to "edit"
    And confirms the "edition"
    Then the customer account should be deactivated successfully

  Scenario: Admin deactivates a customer account
    Given the Admin is logged in
    When the Admin navigates to the "View Customers" section
    And selects a customer account to "edit"
    And cancel the "edition"
    Then the customer account should be deactivated successfully