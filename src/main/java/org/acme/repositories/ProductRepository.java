package org.acme.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.entities.Product;

import java.util.List;

@ApplicationScoped
public class ProductRepository {

    @Inject
    EntityManager em;

    @Transactional
    public void create(Product product) {
        em.persist(product);
    }

    @Transactional
    public List<Product> list() {
        List<Product> products = em.createQuery("Select p from Product p").getResultList();
        return products;
    }
    @Transactional
    public void delete(Product product) {
        em.remove(product);
    }
}
