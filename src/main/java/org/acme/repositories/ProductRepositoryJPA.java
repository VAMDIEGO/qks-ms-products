package org.acme.repositories;

import org.acme.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepositoryJPA extends JpaRepository<Product, Long> {
}
