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

    @Override
    public void save(Product product) {
        if (product.getId() != null && product.getId() > 0) {
            entityManager.merge(product);
        } else {
            entityManager.persist(product);
        }
    }

    @Override
    public void delete(Long id) {
        Product product = findBy(id);
        entityManager.remove(product);
    }

}
