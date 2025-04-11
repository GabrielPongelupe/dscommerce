package com.gabrielpongelupe.dscommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreateUserDTO {
    @NotBlank(message = "Campo name é obrigatório")
    private String name;

    @NotBlank(message = "Campo email é obrigatório")
    private String email;

    @NotBlank(message = "Campo phone é obrigatório")
    private String phone;

    @NotNull(message = "Campo birthday é obrigatório")
    private LocalDate birthday;

    @NotBlank(message = "Campo password é obrigatório")
    private String password;

    // Construtor padrão
    public CreateUserDTO() {}

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public LocalDate getBirthday() { return birthday; }
    public void setBirthday(LocalDate birthday) { this.birthday = birthday; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}
