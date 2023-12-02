package com.app.ManegerAndProduct;

import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service

public class ProductService {

    CardDb cardDb=new CardDb();
    @Autowired
    CatagroisRepositary catagroiesRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CardRepository cardRepository;
    ProductDb productDb;

    Catagroies catagroies;
    @Autowired
    ProductRepository productRepository;
    public String SaveProduct(ProductInfo productInfo,ProductDb productDb) {


        Catagroies catagroies1=catagroiesRepository.findByName(productInfo.getSection());
        boolean exist = productRepository.existsById(productInfo.getProductId());
        if (!exist) {

            productDb.setProductId(productInfo.getProductId());
            productDb.setProductName(productInfo.getProductName());
            productDb.setPrice(productInfo.getPrice());
            productDb.setSection(productInfo.getSection());
            productDb.setNumberOf(productInfo.getNumberOf());
            productDb.setImage(productInfo.getImage());
            productDb.setInformation(productInfo.getInformation());
            productDb.setCategory(catagroies1);

            return "Product added successfully";
        }
        else
            return "Product already exist!";
    }


    public List<String> getAllCategories() {
        return catagroiesRepository.findDistinctCategories();
    }


    public String SaveCatagroies( CatagroiesForm catagroiesForm) {
        boolean exist = catagroiesRepository.existsById( catagroiesForm.getCataId());
        System.out.println(exist);
        boolean nameExist=catagroiesRepository.existsByName(catagroiesForm.getCataName());
        if (!exist) {
            System.out.println("llll");
            catagroies=new Catagroies();
            catagroies.setId(catagroiesForm.getCataId());
            catagroies.setName(catagroiesForm.getCataName());
            catagroies.setImageUrl(catagroiesForm.getImage());
            catagroies.setCategory(catagroiesForm.getCataName());
            catagroiesRepository.save(catagroies);
            return "Category added successfully";
        }
    else if(exist){
            return "The Name already exist";

    }



        return "The Id already exist";

}



public String addToCart(int productId,int userId) {


    Optional<ProductDb> productOptional = productRepository.findById(productId);
    if (productOptional.isPresent()) {
        ProductDb product = productOptional.get();
        int number = product.getNumberOf();
        number -= 1;
        product.setNumberOf(number);
        if (number == 0) {
            product.setAvailable("false");
        }
        productRepository.save(product);



Optional<CustomerDb> customerDbOptional =customerRepository.findById(userId);
   CustomerDb customer=customerDbOptional.get();
        // Create a new CartDb instance
        CardDb cartItem = new CardDb();
        cartItem.setProductDb(product);
        cartItem.setCustomerDb(customer);

         cartItem.setCardId(2);
        cardRepository.save(cartItem);



        return "redirect:/product/{productId}";
    }
    return "product";
}




    public List<ProductDb> getProductsByUserId(int userId) {
        List<CardDb> cards = cardRepository.findByCustomerDbId(userId);
        List<ProductDb> products = new ArrayList<>();

        for (CardDb card : cards) {
            products.add(card.getProductDb());
        }

        return products;
    }

    public String deleteproduct(int productId){

   productRepository.deleteAllById(Collections.singleton(productId));
    return "delete successfully";
}}