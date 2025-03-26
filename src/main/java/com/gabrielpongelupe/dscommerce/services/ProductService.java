package com.gabrielpongelupe.dscommerce.services;

import com.gabrielpongelupe.dscommerce.dto.ProductDTO;
import com.gabrielpongelupe.dscommerce.entities.Product;
import com.gabrielpongelupe.dscommerce.exceptions.DatabaseException;
import com.gabrielpongelupe.dscommerce.exceptions.ResourceNotFoundException;
import com.gabrielpongelupe.dscommerce.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Product product = this.productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recurso não encontrado"));

        return modelMapper.map(product, ProductDTO.class);
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> result = this.productRepository.findAll(pageable);
        return result.map(product -> modelMapper.map(product, ProductDTO.class));
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO){
        Product product = productRepository.save(modelMapper.map(productDTO, Product.class));
        return modelMapper.map(product, ProductDTO.class);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        try{
            Product entity = productRepository.getReferenceById(id);
            entity.setName(productDTO.getName());
            entity.setDescription(productDTO.getDescription());
            entity.setPrice(productDTO.getPrice());
            entity.setImgUrl(productDTO.getImgUrl());

            entity = this.productRepository.save(entity);
            return modelMapper.map(entity, ProductDTO.class); // Retorna o DTO atualizado
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            productRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }



}
