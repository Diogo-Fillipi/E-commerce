package intership.project.ecomerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record CartItemDTO(
        String productId,
        int amount
) {
}
