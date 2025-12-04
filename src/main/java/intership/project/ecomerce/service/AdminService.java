package intership.project.ecomerce.service;

import intership.project.ecomerce.dto.ProductDTO;
import intership.project.ecomerce.dto.UserDTO;
import intership.project.ecomerce.model.product.Product;
import intership.project.ecomerce.model.user.User;
import intership.project.ecomerce.repository.admin.AdminRepository;
import intership.project.ecomerce.repository.product.ProductRepository;
import intership.project.ecomerce.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    AdminService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public ProductDTO createProduct(ProductDTO productdto) {
        Product newProduct = new Product();
        newProduct.setCategory(productdto.category());
        newProduct.setName(productdto.name());
        newProduct.setDescription(productdto.description());
        newProduct.setImageURL(productdto.imageURL());
        productRepository.save(newProduct);

        return productdto;
    }

    public ResponseEntity<UserDTO> createUser (UserDTO userDTO) {
        if(userDTO.age() < 18){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        User newUser = new User();
        newUser.setEmail(userDTO.email());
        newUser.setPassword(userDTO.password());
        newUser.setNamee(userDTO.name());
        newUser.setAge(userDTO.age());
        newUser.setUserType(userDTO.userType());
        userRepository.save(newUser);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public Optional<Product> searchProductByName(String name) {
        Optional<Product> optionalProduct = productRepository.searchProductByProductName(name);
        if(optionalProduct.isPresent()){
            return optionalProduct;
        }
        return null;
    }

    public Optional<Product> searchProductById(Long productId) {
        Optional<Product> optionalProduct = productRepository.searchProductByProductId(productId);
        if(optionalProduct.isPresent()){
            return optionalProduct;
        }
        return null;
    }

    public List<Product> listProducts(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset/limit, limit, Sort.by("category").descending());
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent();
    }

    public Optional<User> searchUserByName(String userName) {
        Optional<User> optionalUser = userRepository.searchUserByName(userName);
        if(optionalUser.isPresent()){
            return optionalUser;
        }
        return null;
    }

    public Optional<User> searchUserById(Long id) {
        Optional<User> optionalUser = userRepository.searchUserById(id);
        if(optionalUser.isPresent()){
            return optionalUser;
        }
        return null;
    }



}
