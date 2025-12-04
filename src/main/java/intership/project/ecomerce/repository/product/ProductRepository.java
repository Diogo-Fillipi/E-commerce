package intership.project.ecomerce.repository.product;

import intership.project.ecomerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> searchProductByProductId(Long productId);
    Optional<Product> searchProductByProductName(String productName);

    Optional<Product> findByName(String name);
}
