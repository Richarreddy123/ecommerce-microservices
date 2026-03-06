package com.richa.inventory_service.controller;

import com.richa.inventory_service.entity.Inventory;
import com.richa.inventory_service.service.InventoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return service.saveInventory(inventory);
    }

    @GetMapping
    public List<Inventory> getInventory() {
        return service.getAllInventory();
    }
    @GetMapping("/{productId}")
    public Inventory getInventoryByProductId(@PathVariable Long productId) {
        return service.getByProductId(productId);
    }
}
