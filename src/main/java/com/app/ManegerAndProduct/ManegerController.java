package com.app.ManegerAndProduct;
import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
import io.cucumber.core.logging.Logger;
import io.cucumber.messages.types.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import java.util.List;

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
            model.addAttribute("products", productList);
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

}}
