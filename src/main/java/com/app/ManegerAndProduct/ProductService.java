package com.app.ManegerAndProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Service

public class ProductService {

    @Autowired
    CatagroisRepositary catagroiesRepository;
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
            catagroies.setImageUrl(catagroiesForm.getImageUrl());
            catagroies.setCategory(catagroiesForm.getCataName());
            catagroiesRepository.save(catagroies);
            return "Catagroies added successfully";
        }
    else if(exist){
            return "The Id already exist";
    }


            return "The Name already exist";


}





}