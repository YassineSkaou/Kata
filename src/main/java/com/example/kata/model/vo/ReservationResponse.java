package com.example.kata.model.vo;

import com.example.kata.model.enums.DeliveryMode;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema
public class ReservationResponse {

    @Schema(name = "L'objet utilisatuer.")
    private UserResponse user;

    @Schema(name = "La date de réservation.")
    private LocalDateTime deliveryTime;

    @Schema(name = "Le mode de livraison.")
    private DeliveryMode deliveryMode;

}
