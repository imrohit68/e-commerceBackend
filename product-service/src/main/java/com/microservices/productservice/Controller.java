package com.microservices.productservice;


import com.microservices.productservice.DTO.ProductDTO;
import com.microservices.productservice.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class Controller {
    private final ProductService productService;
    @PostMapping("createProduct")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO){
        ProductDTO productDTO1 = productService.createProduct(productDTO);
        return new ResponseEntity<>(productDTO1, HttpStatus.CREATED);
    }
    @PutMapping("updateProduct/{productId}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO,@PathVariable int productId){
        ProductDTO productDTO1 = productService.updateProduct(productDTO,productId);
        return new ResponseEntity<>(productDTO1,HttpStatus.OK);
    }
    @GetMapping("getProduct/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int productId){
        ProductDTO productDTO = productService.getProductById(productId);
        return new ResponseEntity<>(productDTO,HttpStatus.FOUND);
    }
    @GetMapping("getProduct")
    public ResponseEntity<List<ProductDTO>> findAllProduct(){
        List<ProductDTO> productDTOS = productService.getAllProducts();
        return new ResponseEntity<>(productDTOS,HttpStatus.FOUND);
    }
    @DeleteMapping("deleteProduct/{productId}")
    public void deleteProduct(@PathVariable int productId){
        productService.deleteProduct(productId);
    }
}
