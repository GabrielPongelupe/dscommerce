package com.gabrielpongelupe.dscommerce.repositories;

import com.gabrielpongelupe.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
