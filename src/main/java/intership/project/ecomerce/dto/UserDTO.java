package intership.project.ecomerce.dto;

import intership.project.ecomerce.model.user.UserType;

public record UserDTO(
        String name,
        String email,
        String password,
        UserType userType
) {
}
