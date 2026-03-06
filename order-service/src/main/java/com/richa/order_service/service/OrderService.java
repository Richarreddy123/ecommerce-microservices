package com.richa.order_service.service;

import com.richa.order_service.dto.InventoryResponse;
import com.richa.order_service.entity.Order;
import com.richa.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public Order saveOrder(Order order) {
        String url = "http://localhost:8082/inventory/" + order.getProductId();

        InventoryResponse inventory = restTemplate.getForObject(url, InventoryResponse.class);

        if (inventory == null) {
            throw new RuntimeException("Inventory not found for product");
        }

        if (inventory.getStock() < order.getQuantity()) {
            throw new IllegalArgumentException("Insufficient stock");
        }

        if (order.getStatus() == null || order.getStatus().isEmpty()) {
            order.setStatus("PLACED");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
