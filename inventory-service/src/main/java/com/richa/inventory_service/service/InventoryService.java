package com.richa.inventory_service.service;

import com.richa.inventory_service.entity.Inventory;
import com.richa.inventory_service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public Inventory saveInventory(Inventory inventory) {
        return repository.save(inventory);
    }

    public List<Inventory> getAllInventory() {
        return repository.findAll();
    }
    public Inventory getByProductId(Long productId) {
        return repository.findByProductId(productId);
    }
}