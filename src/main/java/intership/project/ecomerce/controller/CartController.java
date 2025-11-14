package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.CartItemDTO;
import intership.project.ecomerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/buy")
    public ResponseEntity<?> addItemToCart(@PathVariable Long userId, @PathVariable Long productId, @PathVariable int quantity) {
        return new ResponseEntity<>(cartService.addItemToCart(userId, productId, quantity), HttpStatus.CREATED);
    }

    @DeleteMapping("/remove")
    public ResponseEntity<?> removeItemFromCart(@PathVariable Long userId, @PathVariable Long productId, @PathVariable int quantity) {
        return new ResponseEntity<>(cartService.removeItemFromCart(userId, productId, quantity), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateItem(@PathVariable Long userId, @PathVariable Long productId, @PathVariable int quantity) {
        return new ResponseEntity<>(cartService.updateQuantity(userId, productId, quantity), HttpStatus.OK);
    }

    @GetMapping("/listcart")
    public ResponseEntity<?> listCart(@RequestParam Long userId, @RequestParam int page, @RequestParam int size) {
        return new ResponseEntity<>(cartService.listCartItems(userId, page, size), HttpStatus.OK);
    }

    @GetMapping("/cartprice")
    public ResponseEntity<?> listCartPrice(@RequestParam Long userId) {
        return new ResponseEntity<>(cartService.getCartPrice(userId), HttpStatus.OK);
    }

}
