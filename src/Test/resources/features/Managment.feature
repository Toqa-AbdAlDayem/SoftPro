Feature: Product Management

  Scenario: Add a new product

    Given the user is on the Admin page
    When the admin click on Management
    Then the add product duv should appear and delete and update buttons
    When the admin click on Add product
    Then A form should appear
    Then the user fills in the product details: Product ID 10057 and Product Name "Dash Cams" Information "Record your driving experiences for safety and documentation." and price 500 and section"Electronics " and number of it 60 and an image "url"
    And the manager submits the form
    Then the system should display a success message: "Product added successfully"
    And the added product details should be visible in the product list
