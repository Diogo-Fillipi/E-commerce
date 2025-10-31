package intership.project.ecomerce.controller;

import intership.project.ecomerce.dto.ProductDTO;
import intership.project.ecomerce.dto.UserDTO;
import intership.project.ecomerce.repository.product.ProductRepository;
import intership.project.ecomerce.repository.user.UserRepository;
import intership.project.ecomerce.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> addProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(adminService.createProduct(productDTO));
    }

    @PostMapping("/createuser")
    public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return null;
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchProduct(@RequestParam String productName) {
        return null;
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchProductById(@RequestParam Long productId) {
        return null;
    }

    @GetMapping("/searchall")
    public ResponseEntity<?> searchAllProduct() {
        return null;
    }

    @GetMapping("/products")
    public ResponseEntity<?> listProducts() {
        return null;
    }

    @GetMapping("/productdetails")
    public ResponseEntity<?> listProductDetails(@RequestParam Long productId) {
        return null;
    }

}
