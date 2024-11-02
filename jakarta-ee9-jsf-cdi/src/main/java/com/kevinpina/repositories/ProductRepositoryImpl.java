package com.kevinpina.repositories;

import com.kevinpina.entities.Product;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

import java.util.List;

@RequestScoped
public class ProductRepositoryImpl implements CrudRepository<Product> {

    @Inject
    private EntityManager entityManager;

    @Override
    public List<Product> list() {
        return entityManager.createQuery("select p from Product p", Product.class).getResultList();
    }

    @Override
    public Product findBy(Long id) {
        return entityManager.find(Product.class, id);
    }

}
