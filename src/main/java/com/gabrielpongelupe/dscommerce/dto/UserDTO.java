package com.gabrielpongelupe.dscommerce.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.apache.logging.log4j.message.Message;

import java.time.LocalDate;

public class UserDTO {
    @NotBlank(message = "campo name é requerido")
    private String name;

    @NotBlank(message = "campo email é requerido")
    private String email;

    @NotBlank(message = "campo phone é requerido")
    private String phone;

    @NotBlank(message = "campo birthday é requerido")
    private LocalDate birthday;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
