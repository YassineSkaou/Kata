package com.example.kata.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Schema
@Getter
@Setter
@AllArgsConstructor
public class UserResponse {


    @Schema(name = "Id du client.")
    private Long id;

    @Schema(name = "Nom du client.")
    private String username;

    @Schema(name = "Adresse mail du client.")
    private String email;

}
