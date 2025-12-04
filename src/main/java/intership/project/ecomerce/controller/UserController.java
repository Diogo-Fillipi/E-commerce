package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.CartDTO;
import intership.project.ecomerce.dto.CartItemDTO;
import intership.project.ecomerce.dto.ProductDTO;
import intership.project.ecomerce.model.order.Order;
import intership.project.ecomerce.model.product.Product;
import intership.project.ecomerce.repository.product.ProductRepository;
import intership.project.ecomerce.repository.user.UserRepository;
import intership.project.ecomerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/products")
    public List<Product> listProducts(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit) {
        return userService.listProducts(offset, limit);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProductByName(@RequestParam String productName) {
        return new ResponseEntity<>(userService.getProductByName(productName), HttpStatus.OK);
    }


    @GetMapping("/productdetails")
    public ResponseEntity<?> listProductDetails(@RequestParam Long productId) {
        return null;
    }



}