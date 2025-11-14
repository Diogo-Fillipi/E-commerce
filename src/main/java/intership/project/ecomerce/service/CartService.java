package intership.project.ecomerce.service;

import intership.project.ecomerce.model.cart.Cart;
import intership.project.ecomerce.model.cart.CartItem;
import intership.project.ecomerce.model.product.Product;
import intership.project.ecomerce.model.user.User;
import intership.project.ecomerce.repository.cart.CartItemRepository;
import intership.project.ecomerce.repository.cart.CartRepository;
import intership.project.ecomerce.repository.product.ProductRepository;
import intership.project.ecomerce.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartService(CartRepository cartRepository, UserRepository userRepository, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    public Cart addItemToCart(Long userId, Long productId, int quantity) {

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User Not Found"));

        Cart cart = user.getCart();
        if(cart == null){
            cart = new Cart();
            cart.setUser(user);
            user.setCart(cart);
        }

        Optional<CartItem> existingItem = cart.getItems().stream()
                .filter(item -> item.getProductId().equals(productId))
                .findFirst();

        if (existingItem.isPresent()) {

            existingItem.get().setQuantity(existingItem.get().getQuantity() + quantity);
        } else {

            Product product = productRepository.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            CartItem newItem = new CartItem();
            newItem.setProductId(productId);
            newItem.setQuantity(quantity);
            newItem.setCart(cart);
            newItem.setPrice(product.getPrice());

            cart.getItems().add(newItem);
        }

        return cartRepository.save(cart);
    }

    public Cart removeItemFromCart(Long userId, Long productId, int quantity) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User Not Found"));

        Cart cart = user.getCart();
        if (cart == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        CartItem item = cart.getItems().stream()
                .filter(i -> i.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item Not Found"));

        int newQuantity = item.getQuantity() - quantity;

        if (newQuantity <= 0) {
            cart.getItems().remove(item); // remove e apaga do banco
        } else {
            item.setQuantity(newQuantity);
        }

        return cartRepository.save(cart);
    }

    public Cart updateQuantity(Long userId, Long productId, int quantity) {
        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User Not Found")
        );

        Cart cart = user.getCart();
        if (cart == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        CartItem item = cart.getItems().stream()
                .filter(i -> i.getProductId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Item Not Found"));

        if (quantity <= 0) {
            cart.getItems().remove(item);
        } else {
            item.setQuantity(quantity);
        }

        return cartRepository.save(cart);
    }

    public List<CartItem> listCartItems(Long userId, int page, int size) {

        User user = userRepository.findById(userId).orElseThrow(
                ()-> new RuntimeException("User Not Found")
        );

        Cart cart = user.getCart();
        if (cart == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }
        Pageable pageable = PageRequest.of(page, size);

        return cartItemRepository.findByCart(cart, pageable).getContent();
    }

    public BigDecimal getCartPrice(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new RuntimeException("User Not Found"));

        Cart cart = user.getCart();
        if (cart == null || cart.getItems().isEmpty()) {
            throw new RuntimeException("Cart is empty");
        }

        return cart.getItems().stream()
                .map(item -> item.getPrice()
                        .multiply(BigDecimal.valueOf(item.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

    }

}
