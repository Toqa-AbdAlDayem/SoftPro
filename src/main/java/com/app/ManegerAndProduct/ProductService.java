package com.app.ManegerAndProduct;

import com.app.customer.CustomerDb;
import com.app.customer.CustomerRepository;
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
    public String SaveProduct(ProductInfo productInfo) {

        boolean exist = productRepository.existsById(productInfo.getProductId());
        if (!exist) {
            productDb = new ProductDb();
            productDb.setProductId(productInfo.getProductId());
            productDb.setProductName(productInfo.getProductName());
            productDb.setPrice(productInfo.getPrice());
            productDb.setSection(productInfo.getSection());
            productDb.setNumberOf(productInfo.getNumberOf());
            productDb.setImage(productInfo.getImage());
            productDb.setInformation(productInfo.getInformation());

            productRepository.save(productDb);
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
        boolean nameExist=catagroiesRepository.existsByName(catagroiesForm.getCataName());
        if (!exist) {
            catagroies=new Catagroies();
            catagroies.setId(catagroiesForm.getCataId());
            catagroies.setName(catagroiesForm.getCataName());
            catagroies.setImageUrl(catagroiesForm.getImage());
            catagroies.setCategory(catagroiesForm.getCataName());
            catagroiesRepository.save(catagroies);
            return "Catagroies added successfully";
        }
    else if(exist){
            return "The Id already exist";
    }


            return "The Name already exist";


}



/*public String addToCart(int productId) {
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


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        CustomerDb customer = customerRepository.findByUsername(username);

        // Create a new CartDb instance
        CardDb cartItem = new CardDb();
        cartItem.setProductDb(product);
        cartItem.setCustomerDb(customer);


        cardRepository.save(cartItem);

        // You can add a success message or perform additional actions here

        return "redirect:/product/{productId}";
    }
}*/




    public List<ProductDb> getProductsByUserId(int userId) {
        List<CardDb> cards = cardRepository.findByCustomerDbId(userId);
        List<ProductDb> products = new ArrayList<>();

        for (CardDb card : cards) {
            products.add(card.getProductDb());
        }

        return products;
    }

    public List<ProductDb> searchProducts(String term) {
        // Implement your logic to search for products in the database
        // You might use the productRepository to query the database
        return productRepository.findByProductNameContainingIgnoreCase(term);
    }
}