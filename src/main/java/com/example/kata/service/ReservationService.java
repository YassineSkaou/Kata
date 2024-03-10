package com.example.kata.service;

import com.example.kata.mapper.ReservationMapper;
import com.example.kata.model.enums.DeliveryMode;
import com.example.kata.model.po.Reservation;
import com.example.kata.model.vo.ReservationRequest;
import com.example.kata.model.vo.ReservationResponse;
import com.example.kata.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final ReservationMapper mapper;

    public ReservationResponse addReservation(ReservationRequest reservationRequest) {
        Reservation reservation = mapper.mapToReservation(reservationRequest);

        reservation.setUser(userService.findByUserName(reservationRequest.getUser().getUsername()));

        if (reservation.getDeliveryMode() == DeliveryMode.DELIVERY_ASAP)
            reservation.setDeliveryTime(LocalDateTime.now());

        return mapper.mapToReservationResponse(reservationRepository.save(reservation));
    }

    public List<ReservationResponse> getAllReservations(Long clientId, PageRequest pageRequest) {
        Page<Reservation> page = reservationRepository.findByUserId(clientId, pageRequest);

        return page.getContent().stream()
                .map(mapper::mapToReservationResponse)
                .collect(Collectors.toList());
    }

}
