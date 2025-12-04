package intership.project.ecomerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record CartDTO(
        String cartId
) {
}
