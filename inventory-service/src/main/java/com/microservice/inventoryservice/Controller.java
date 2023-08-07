package com.microservice.inventoryservice;

import com.microservice.inventoryservice.Dto.InventoryResponse;
import com.microservice.inventoryservice.Entity.Inventory;
import com.microservice.inventoryservice.Repo.InventoryRepo;
import com.microservice.inventoryservice.Services.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class Controller {
    private final InventoryService inventoryService;
    @GetMapping
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
