Feature: Product Management

  Scenario: Add a new product

    Given the user is on the Admin page
    When the admin click on Add product
    Then the Add product form should appear
    Then the user fills in the product details:
      | Product ID  | Product Name  | Information                                   | Price   | Section      | Number of | Image  |
      | 12345       | Smartphone    | High-performance smartphone with advanced features. | 599.99  | Electronics  | 50        | (User selects a valid image file) |
    And the manager submits the form
    Then the system should display a success message: "Product added successfully"
    And the added product details should be visible in the product list
