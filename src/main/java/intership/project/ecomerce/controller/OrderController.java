package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.CartDTO;
import intership.project.ecomerce.model.order.Order;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody @Valid CartDTO cartDTO) {
        return null;
    }
    @PostMapping("/payment")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        return null;
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<?> orderStatus(@RequestParam Long orderId){
        return null;
    }

    @PatchMapping("/cancel")
    public ResponseEntity<?> cancelOrder(@RequestParam Long orderId){
        return null;
    }
}
