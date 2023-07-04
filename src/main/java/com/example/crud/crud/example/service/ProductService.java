package com.example.crud.crud.example.service;

import com.example.crud.crud.example.entity.Product;
import com.example.crud.crud.example.service.Exception.ResourceNotFoundException;

public interface ProductService {
    //for create Product
    Product createProduct(Product product);
    //for Update Product
    Product updateProduct(Product product) throws ResourceNotFoundException;
    //for Get All Product
    Iterable<Product> getAllProduct();
    //for get bY ID
    Product getProductById(long productId);
    //For delete
    void deleteProduct(long id) throws ResourceNotFoundException;
}
