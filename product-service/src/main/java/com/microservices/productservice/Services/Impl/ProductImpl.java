package com.microservices.productservice.Services.Impl;


import com.microservices.productservice.DTO.ProductDTO;
import com.microservices.productservice.Repo.ProductRepo;
import com.microservices.productservice.Services.ProductService;
import com.microservices.productservice.entities.Product;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductImpl implements ProductService {
    private final ModelMapper modelMapper;
    private final ProductRepo productRepo;
    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO,Product.class);
        Product get = productRepo.save(product);
        return modelMapper.map(get,ProductDTO.class);
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, int productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        product.setDescription(productDTO.getDescription());
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setImage(productDTO.getImage());
        Product product1 = productRepo.save(product);
        return modelMapper.map(product1,ProductDTO.class);
    }

    @Override
    public ProductDTO getProductById(int productId) {
        Product product = productRepo.findById(productId).orElseThrow();
        return modelMapper.map(product,ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        List<ProductDTO> productDTOS = products.stream().map(product -> modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());
        return productDTOS;
    }

    @Override
    public void deleteProduct(int productId) {
        productRepo.deleteById(productId);
    }
}
