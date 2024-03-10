package com.example.kata.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema
@Getter
@Setter
@AllArgsConstructor
public class UserRequest {

    @Schema(name = "Id du client.")
    private Long id;

    @NotBlank(message = "Champ obligatoire.")
    @Pattern(regexp = "(^[a-zA-ZÀ-ÿ-' ]*$)", message = "Le format n’est pas valide.")
    @Schema(name = "Nom du client.")
    private String username;

    @NotBlank(message = "Champ obligatoire.")
    @Email(message = "Le format de l’adresse email est incorrect.")
    @Schema(name = "Adresse mail du client.")
    private String email;

}
