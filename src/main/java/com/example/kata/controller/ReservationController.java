package com.example.kata.controller;

import com.example.kata.model.vo.ReservationRequest;
import com.example.kata.model.vo.ReservationResponse;
import com.example.kata.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/delivery")
@Tag(name = "Gestion des réservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    @Operation(summary = "Récupération de la liste des réservations associées à un client.")
    public List<ReservationResponse> getReservations(@RequestParam Long idClient, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {

        // Crée une instance de PageRequest pour la pagination
        PageRequest pageRequest = PageRequest.of(page, size);

        // Récupère les réservations du client spécifié en utilisant la pagination
        return reservationService.getAllReservations(idClient, pageRequest);
    }

    @PostMapping
    @Operation(summary = "Création d'une nouvelle réservation")
    public ResponseEntity<ReservationResponse> createReservation(@Parameter(name = "Information saisie par l'utilisateur .") @Valid @RequestBody ReservationRequest reservationRequest) {
        ReservationResponse reservation = reservationService.addReservation(reservationRequest);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

}
