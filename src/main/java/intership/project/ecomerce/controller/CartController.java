package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.CartItemDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @PostMapping("/buy")
    public ResponseEntity<?> addItemToCart(@RequestBody CartItemDTO cartItemDTO) {
        return null;
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeItemFromCart(@RequestBody CartItemDTO cartItemDTO) {
        return null;
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@RequestBody CartItemDTO cartItemDTO) {
        return null;
    }

    @GetMapping("/listcart")
    public ResponseEntity<?> listCart() {

        return null;
    }

    @GetMapping("/cartprice")
    public ResponseEntity<?> listCartPrice() {
        return null;
    }

}
