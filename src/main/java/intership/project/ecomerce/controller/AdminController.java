package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.ProductDTO;
import intership.project.ecomerce.dto.UserDTO;
import intership.project.ecomerce.model.product.Product;
import intership.project.ecomerce.model.user.User;
import intership.project.ecomerce.repository.product.ProductRepository;
import intership.project.ecomerce.repository.user.UserRepository;
import intership.project.ecomerce.service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addProduct(@RequestBody @Valid ProductDTO productDTO) {
        return ResponseEntity.ok(adminService.createProduct(productDTO));
    }

    @PostMapping("/createuser")
    public ResponseEntity<UserDTO> addUser(@RequestBody @Valid UserDTO userDTO) {
        return adminService.createUser(userDTO);
    }

    @GetMapping("/search/{name}")
    public Optional<User> searchUserByName(@PathVariable String name) {
        return adminService.searchUserByName(name);
    }

    @GetMapping("/search/{id}")
    public Optional<User> searchUserByName(@PathVariable Long id) {
        return adminService.searchUserById(id);
    }

    @GetMapping("/search/{name}")
    public Optional<Product> searchProductByName(@PathVariable String name) {
        return adminService.searchProductByName(name);
    }
    @GetMapping("/search/{id}")
    public Optional<Product> productDetails(@PathVariable @Valid Long productId) {
        return adminService.searchProductById(productId);
    }

    @GetMapping("/products")
    public List<Product> listProducts(@RequestParam(defaultValue = "0") int offset, @RequestParam(defaultValue = "20") int limit) {
        return adminService.listProducts(offset, limit);
    }

}
