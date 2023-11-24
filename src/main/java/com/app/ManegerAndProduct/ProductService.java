package com.app.ManegerAndProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProductService {

    ProductDb productDb;
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

}