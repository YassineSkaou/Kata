package com.example.kata.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Schema
@Getter
@Setter
@Builder
public class AuthResponse {

    @Schema(name = "Nom du client.")
    private String username;

    @Schema(name = "Le token généré.")
    private String token;

}
