package intership.project.ecomerce.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record ProductDTO(
        String name,
        String description,
        String price,
        int storage,
        String category,
        String imageURL
) {
}
