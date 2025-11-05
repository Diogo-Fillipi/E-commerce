package intership.project.ecomerce.dto;

public record ProductDTO(
        String name,
        String description,
        String price,
        int storage,
        String category,
        String imageURL
) {
}
