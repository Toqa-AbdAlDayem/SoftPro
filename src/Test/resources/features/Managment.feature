Background:
Given the user is on the Admin page

Scenario: Add a new category successfully
When the admin clicks on Management
Then the "Add Category" section should appear with delete button
When the admin clicks on Add Category
Then a form should appear
And the admin fills in the category details: Category Name "Luxury Parts"
And the manager submits the form
Then the system should display a success message: "Category added successfully"
And the added category should be visible on the home page

Scenario: Add a new category with an existing category
When the admin clicks on Management
Then the "Add Category" section should appear with delete button
When the admin clicks on Add Category
Then a form should appear
And the admin fills in the category details: Category Name "Exterior Accessories"
And the manager submits the form
Then the system should display an error message: "Category already exists"
And the existing category should be visible on the home page

Scenario: Delete a category successfully
When the admin clicks on Management
Then the "Add Category" section should appear with delete button
When the admin clicks on Delete Category
Then an alert should appear asking for confirmation
When the admin clicks on Yes
Then the category should be deleted successfully
And the category should not be visible on the home page

Scenario: Cancel deleting a category
When the admin clicks on Management
Then the "Add Category" section should appear with delete button
When the admin clicks on Delete Category
Then an alert should appear asking for confirmation
When the admin clicks on No
Then the category should still be visible on the home page

Scenario: Add a new product successfully
When the admin clicks on "Exterior Accessories" category
Then the admin should see a list of products
When the admin clicks on Management
Then the "Add Product" section should appear with delete and update buttons
When the admin clicks on Add Product
Then a form should appear
And the admin fills in the product details: Product ID 10057, Product Name "Dash Cams", Information "Record your driving experiences...", Price 500, Section "Electronics", Number 60, Image "url"
And the manager submits the form
Then the system should display a success message: "Product added successfully"
And the added product details should be visible in the product list

Scenario: Add a new product with an existing product
When the admin clicks on "Exterior Accessories" category
Then the admin should see a list of products
When the admin clicks on Management
Then the "Add Product" section should appear with delete and update buttons
When the admin clicks on Add Product
Then a form should appear
And the admin fills in the product details: Product ID 10057, Product Name "Light", Information "Record your driving experiences...", Price 500, Section "Electronics", Number 60, Image "url"
And the manager submits the form
Then the system should display an error message: "Product already exists"

Scenario: Update a product successfully
When the admin clicks on "Exterior Accessories" category
Then the admin should see a list of products
When the admin clicks on Management
Then the "Add Product" section should appear with delete and update buttons
When the admin clicks on Update Product
Then a form should appear with the previous product data
And the admin fills in the updated product details: Product Name "New Dash Cams", Information "Enhanced recording experiences...", Price 600, Section "Electronics", Number 70, Image "new_url"
And the manager submits the form
Then the system should display a success message: "Product updated successfully"

Scenario: Delete a product successfully
When the admin clicks on "Exterior Accessories" category
Then the admin should see a list of products
When the admin clicks on Management
Then the "Add Product" section should appear with delete and update buttons
When the admin clicks on Delete Product
Then an alert should appear asking for confirmation
When the admin clicks on Yes
Then the product should be deleted successfully
And the product should not be visible in the product list
