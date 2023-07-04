package com.example.crud.crud.example.service;

import com.example.crud.crud.example.entity.Product;
import com.example.crud.crud.example.repository.ProductRepository;
import com.example.crud.crud.example.service.Exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepo;

    @Override
    public Product createProduct(Product product) {
        return productRepo.save(product) ;
    }

    @Override
    public Product updateProduct(Product product) throws ResourceNotFoundException {
       Optional<Product> productDb=   productRepo.findById(product.getId());
       if(productDb.isPresent()) {
           Product updateProduct = productDb.get();
           updateProduct.setId(product.getId());
           updateProduct.setName(product.getName());
           updateProduct.setDescription(product.getDescription());
           updateProduct.setPrice(product.getPrice());
           return updateProduct;
       }
       else {
           throw  new ResourceNotFoundException("Resource not found with id"+ product.getId());
       }

       }

    @Override
    public List<Product> getAllProduct() {
        return productRepo.findAll();

    }


    @Override
    public Product getProductById(long productId) {

        return productRepo.findById(productId).get();
    }

    @Override
    public void deleteProduct(long id) throws ResourceNotFoundException {
        Optional<Product> update = productRepo.findById(id);
        if (update.isPresent()) {
            productRepo.delete(update.get());


        } else {
            throw new ResourceNotFoundException("Record  not found with id" + id);
        }
    }
}
