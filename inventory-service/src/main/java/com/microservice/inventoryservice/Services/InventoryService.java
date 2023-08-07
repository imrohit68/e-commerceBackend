package com.microservice.inventoryservice.Services;

import com.microservice.inventoryservice.Dto.InventoryDto;
import com.microservice.inventoryservice.Dto.InventoryResponse;
import com.microservice.inventoryservice.Entity.Inventory;
import com.microservice.inventoryservice.Repo.InventoryRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryRepo inventoryRepo;
    public List<InventoryResponse> isInStock(List<String> skuCode){
        return inventoryRepo.findBySkuCodeIn(skuCode)
                .stream().map(inventory ->
                    InventoryResponse.builder()
                            .skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()
                ).toList();
    }
}
