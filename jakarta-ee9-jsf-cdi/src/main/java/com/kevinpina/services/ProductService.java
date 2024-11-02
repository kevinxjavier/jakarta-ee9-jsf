package com.kevinpina.services;

import com.kevinpina.entities.Product;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductService {

    List<Product> listProducts();
    Optional<Product> getProduct(Long id);

}
