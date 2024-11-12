package com.kevinpina.services;

import com.kevinpina.entities.Product;
import com.kevinpina.repositories.CrudRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;

@Stateless
public class ProductServiceImpl implements ProductService {

    @Inject
    private CrudRepository<Product> productRepository;

    @Override
    public List<Product> listProducts() {
        return productRepository.list();
    }

    @Override
    public Optional<Product> getProduct(Long id) {
        return Optional.ofNullable(productRepository.findBy(id));
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.delete(id);
    }

}
