package com.gabrielpongelupe.dscommerce.services;

import com.gabrielpongelupe.dscommerce.dto.ProductDTO;
import com.gabrielpongelupe.dscommerce.entities.Product;
import com.gabrielpongelupe.dscommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = this.productRepository.findById(id).get();
        return new ProductDTO(product);
    }
}
