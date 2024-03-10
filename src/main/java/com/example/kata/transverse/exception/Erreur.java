package com.example.kata.transverse.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class Erreur {

    private String code;
    private String message;
    Map<String, String> erreurs;

}