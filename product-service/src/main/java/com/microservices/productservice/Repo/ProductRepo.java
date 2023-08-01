package com.microservices.productservice.Repo;

import com.microservices.productservice.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
