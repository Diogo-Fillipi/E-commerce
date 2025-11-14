package intership.project.ecomerce.repository.cart;

import intership.project.ecomerce.model.cart.Cart;
import intership.project.ecomerce.model.cart.CartItem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Page<CartItem> findByCart(Cart cart, Pageable pageable);

}
