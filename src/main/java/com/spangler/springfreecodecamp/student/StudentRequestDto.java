package com.spangler.springfreecodecamp.student;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public record StudentRequestDto(
        @NotEmpty(message = "First name cannot be empty")
        String firstName,

        @NotEmpty(message = "Last name cannot be empty")
        String lastName,

        @Email
        @NotEmpty(message = "Email cannot be empty")
        String email,

        Long schoolId
) {
}
