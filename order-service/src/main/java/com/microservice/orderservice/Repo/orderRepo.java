package com.microservice.orderservice.Repo;

import com.microservice.orderservice.Entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepo extends JpaRepository<Orders,Long> {

}
