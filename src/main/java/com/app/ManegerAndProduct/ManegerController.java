package com.app.ManegerAndProduct;
import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
import io.cucumber.core.logging.Logger;
import io.cucumber.messages.types.Product;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Controller
public class ManegerController {

    private CatagroiesForm catagroiesInfo;
    private final ProductService  productService;


    @GetMapping("/model")
    public String showModel(Model model){


        return "error";
    }


@Autowired
private ProductRepository productRepository;
ProductDb productDb=new ProductDb();
@Autowired

    public ManegerController(ProductService productService, CatagroisRepositary catagroisRepositary) {
        this.productService = productService;
    this.catagroisRepositary = catagroisRepositary;
}

    @GetMapping("/category/{categoryId}")
    public String getProductFromCatagroies(@PathVariable int categoryId, Model model) {
        List<ProductDb> productList =productRepository.findByCategoryId(categoryId);
        model.addAttribute("products", productList);
        return "product"; // Return the name of the Thymeleaf template (product.html)
    }


    @GetMapping("/product/{productId}")
    public String getProduct(@PathVariable int productId, Model model) {

        Optional<ProductDb> productOptional = productRepository.findById(productId);

        if (productOptional.isPresent()) {
            ProductDb product = productOptional.get();
            model.addAttribute("product", product);
        }
return "productList";
    }

    @PostMapping("/add-product")
    public boolean addProduct(ProductInfo productInfo) {

   String isAdd =productService.SaveProduct(productInfo);




        return true;


    }

    private final CatagroisRepositary catagroisRepositary;


    @GetMapping("/select")
    public String yourMapping(Model model) {
        List<String> sections = productService.getAllCategories();
        model.addAttribute("sections", sections);
        return "Home";
    }


    @GetMapping("/all")
        public String getAllProducts(Model model) {
            List<Catagroies> productList = catagroisRepositary.findAll();
            model.addAttribute("categories", productList);
             return "Home";
    }


 @PostMapping("/add-catagroies")
    public String addCatagroies(@ModelAttribute CatagroiesForm catagroiesForm,Model model){
System.out.println(catagroiesForm.getCataName());

     String isAdd =productService.SaveCatagroies(catagroiesForm);
     System.out.println(isAdd);
     if (isAdd.equals("The Id already exist")){


     }
     else if (isAdd.equals("The Name already exist")){


}
     return "redirect:/home";

 }




 @GetMapping("/search/{productId}")
public String viewProduct(@PathVariable Long productId, Model model) {
     List<ProductDb> productList = productRepository.findAll();

     model.addAttribute("products", productList);

     return "productList";

}

 /*   @PostMapping("/add-to-cart/{productId}")
    public String addToCart(@PathVariable int productId, Model model) {
        // Logic to add the product to the cart
        productService.addToCart(productId);

        // You can add a success message or perform additional actions here

        return "redirect:/product/{productId}"; // Redirect back to the product details page
    }*/

    @GetMapping("/user/{userId}/card")
    public String showUserCardDetails(@PathVariable int userId, Model model, HttpSession session) {

        List<ProductDb> products = productService.getProductsByUserId(userId);
        model.addAttribute("products", products);
        model.addAttribute("userId", userId);
        return "ShoppingList";
    }

}
