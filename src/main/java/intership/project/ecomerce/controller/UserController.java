package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.CartDTO;
import intership.project.ecomerce.dto.CartItemDTO;
import intership.project.ecomerce.dto.ProductDTO;
import intership.project.ecomerce.model.order.Order;
import intership.project.ecomerce.model.product.Product;
import intership.project.ecomerce.repository.product.ProductRepository;
import intership.project.ecomerce.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    UserController(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProduct(@RequestParam String productName) {
        return null;
    }

    @GetMapping("/products")
    public ResponseEntity<?> listProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/productdetails")
    public ResponseEntity<?> listProductDetails(@RequestParam Long productId) {
        return null;
    }



}