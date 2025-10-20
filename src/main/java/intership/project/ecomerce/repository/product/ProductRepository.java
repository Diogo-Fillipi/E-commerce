package intership.project.ecomerce.repository.product;

import intership.project.ecomerce.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
