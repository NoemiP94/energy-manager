package payloads.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record UserDTO(
        @NotNull(message = "email cannot be null")
        @NotEmpty(message = "email cannot be empty")
        @Email
        String email,
        @NotNull(message = "name cannot be null")
        @NotEmpty(message = "name cannot be empty")
        String name,
        @NotNull(message = "surname cannot be null")
        @NotEmpty(message = "surname cannot be empty")
        String surname,
        @NotNull(message = "password cannot be null")
        @NotEmpty(message = "password cannot be empty")
        @Size(min=4, max=16, message = "password mist be between 4 and 16 chars")
        String password
) {
}
