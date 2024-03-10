package com.example.kata.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema
@Getter
@Setter
@AllArgsConstructor
public class AuthRequest {


    @Schema(name = "Nom du client.")
    private String username;

    @Schema(name = "Le mot de passe.")
    private String password;

}
