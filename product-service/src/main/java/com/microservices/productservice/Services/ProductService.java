package com.microservices.productservice.Services;

import com.microservices.productservice.DTO.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO createProduct(ProductDTO productDTO);
    ProductDTO updateProduct(ProductDTO productDTO, int productId);
    ProductDTO getProductById(int productId);
    List<ProductDTO> getAllProducts();
    void deleteProduct(int productId);
}
