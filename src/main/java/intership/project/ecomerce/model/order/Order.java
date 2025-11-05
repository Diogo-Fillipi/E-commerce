package intership.project.ecomerce.model.order;

import intership.project.ecomerce.model.cart.Cart;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long orderId;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    Cart cart;

    @Enumerated
    Status status;
}
