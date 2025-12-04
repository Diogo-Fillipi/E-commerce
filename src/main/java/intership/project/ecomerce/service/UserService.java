package intership.project.ecomerce.service;

import intership.project.ecomerce.model.product.Product;
import intership.project.ecomerce.repository.product.ProductRepository;
import intership.project.ecomerce.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public UserService(UserRepository userRepository, ProductRepository productRepository) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Product getProductByName(String name) {
        Optional<Product> foundProduct = productRepository.findByName(name);
        if(foundProduct.isPresent()){
            Product product = foundProduct.get();
            return product;
        } else {
            throw new ResourceNotFoundException("Product with name " + name + " not found");
        }
    }

    public List<Product> listProducts(int offset, int limit) {
        Pageable pageable = PageRequest.of(offset/limit, limit, Sort.by("category").descending());
        Page<Product> products = productRepository.findAll(pageable);
        return products.getContent();
    }
}
