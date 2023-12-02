Feature: Product Management

  Background:
    Given the user is on the Admin page

Scenario: Add a new product successfully
When the admin clicks on "Exterior Accessories" category
Then the admin should be in a "Exterior Accessories" product page
When the admin clicks on Management
Then the "Add Product" section should appear with delete button
When the admin clicks on Add Product
Then a form should appear
And the admin fills in the product details with new product : Product ID "57", Product Name "Dash Cams", Information "Record your driving experiences...", Price "500", Section "Electronics", Number "60", Image "url"
And the manager submits the form
Then the system should display a success message: "Product added successfully"


Scenario: Add a new product but it already existing product
When the admin clicks on "Exterior Accessories" category
Then the admin should be in a "Exterior Accessories" product page
When the admin clicks on Management
Then the "Add Product" section should appear with delete and update buttons
When the admin clicks on Add Product
Then a form should appear
And the admin fills in the product details: Product ID "157", Product Name "Light", Information "Record your driving experiences...", Price "500", Section "Electronics", Number "60", Image "url"
And the manager submits the form
Then the system should display an error message: "The Name already exist"

Scenario: Update a product successfully
When the admin clicks on "Exterior Accessories" category
Then the admin should be in a "Exterior Accessories" product page
When the admin clicks on Management
Then the "Add Product" section should appear with delete and update buttons
When the admin clicks on Update Product
Then a form should appear with the previous product data
And the admin fills in the updated product details: Product Name "Window Tint", Information "Enhanced recording experiences...", Price "600", Section "Electronics", Number "70", Image "new_url"
And the manager submits the update form
Then the system should display a success message: "Product updated successfully"

Scenario: Delete a product successfully
When the admin clicks on "Exterior Accessories" category
Then the admin should be in a "Exterior Accessories" product page
When the admin clicks on Management
Then the "Add Product" section should appear with delete and update buttons
When the admin clicks on Delete Product
Then an alert should appear asking for confirmation
When the admin clicks on Yes
Then the product should be deleted successfully

  Scenario: Cancel delete
    When the admin clicks on "Exterior Accessories" category
    Then the admin should be in a "Exterior Accessories" product page
    When the admin clicks on Management
    When the admin clicks on Delete Product
    Then an alert should appear asking for confirmation
    When the admin clicks on No
    Then the product should not be deleted


  Scenario:Cancel Add a new product successfully
    When the admin clicks on "Exterior Accessories" category
    Then the admin should be in a "Exterior Accessories" product page
    When the admin clicks on Management
    Then the "Add Product" section should appear with delete button
    When the admin clicks on Add Product
    Then a form should appear
    And the admin clicks on Cancel
    Then Nothing new should appear

  Scenario: Cancel update
    When the admin clicks on "Exterior Accessories" category
    Then the admin should be in a "Exterior Accessories" product page
    When the admin clicks on Management
    When the admin clicks on Update Product
    When the admin clicks on Update Product
    Then a form should appear with the previous product data
    And the admin clicks on Cancel
    Then the form should be closed, and the product details remain unchanged