package intership.project.ecomerce.dto;

import intership.project.ecomerce.model.user.UserType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDTO(

        @Valid

        @NotBlank(message = "Name is mandatory")
        String name,
        @NotBlank(message = "Email is mandatory")
        String email,
        @NotBlank(message = "Password is mandatory")
        String password,
        @NotBlank(message = "Age is mandatory")
        int age,
        @NotBlank(message = "UserType is mandatory")
        UserType userType
) {
}
