package com.example.kata.model.vo;

import com.example.kata.model.enums.DeliveryMode;
import com.example.kata.transverse.validation.EnumValidator;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Schema
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequest {

    @NotNull
    @Schema(name = "L'objet utilisatuer.")
    UserRequest user;

    @NotNull
    @Future(message = "La date de réservation doit être dans le futur.")
    @Schema(name = "La date de réservation.")
    private LocalDateTime deliveryTime;

    @Schema(name = "Le mode de livraison.")
    @EnumValidator(enumClass = DeliveryMode.class)
    private DeliveryMode deliveryMode;

}
