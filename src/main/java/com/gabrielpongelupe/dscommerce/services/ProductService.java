package com.gabrielpongelupe.dscommerce.services;

import com.gabrielpongelupe.dscommerce.dto.ProductDTO;
import com.gabrielpongelupe.dscommerce.entities.Product;
import com.gabrielpongelupe.dscommerce.repositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = this.productRepository.findById(id).get();
        return modelMapper.map(product, ProductDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = this.productRepository.findAll(pageable);
        return result.map(product -> modelMapper.map(product, ProductDTO.class));
    }


}
