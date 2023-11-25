package com.app.ManegerAndProduct;
import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class ManegerController {

    private final ProductService  productService;

@Autowired
private ProductRepository productRepository;
ProductDb productDb=new ProductDb();
@Autowired

    public ManegerController(ProductService productService, CatagroisRepositary catagroisRepositary) {
        this.productService = productService;
    this.catagroisRepositary = catagroisRepositary;
}


/*    @PostMapping("/add-product")
    public boolean addProduct(ProductInfo productInfo) {

String isAdd =productService.SaveProduct(productInfo);


           *//*
           احططططططططططططططططططط يطلع pop uppppppp
            *//*

        return true;


    }*/
    private final CatagroisRepositary catagroisRepositary;



    @GetMapping("/all")

        public String getAllProducts(Model model) {
            List<Catagroies> productList = catagroisRepositary.findAll();

            // Add the productList to the model with a specific attribute name
            model.addAttribute("products", productList);
        return "Home";
    }

@PostMapping("/add-product")
public String addProduct(ProductInfo productInfo){

        return "manager";


}



  /*


    ههههوووون عشان اضيف ال product list
    @GetMapping("/product/{productId}")
    public String viewProduct(@PathVariable Long productId, Model model) {
        // Logic to retrieve product details from productId
        // You can use the productId to fetch the specific product from your database or service
        // For simplicity, let's assume you have a method getProductById in a service class

        // productService.getProductById(productId);

        // Add the product details to the model (replace with actual logic)
        model.addAttribute("productName", "Sample Product");
        model.addAttribute("productDescription", "Sample Product Description");

        // Return the Thymeleaf template for displaying detailed product information
        return "productDetails";
    }*/
}
