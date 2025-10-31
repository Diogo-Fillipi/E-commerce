package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.CartDTO;
import intership.project.ecomerce.model.order.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestBody CartDTO cartDTO) {
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
