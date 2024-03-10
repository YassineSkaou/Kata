package com.example.kata.service;

import com.example.kata.mapper.ReservationMapper;
import com.example.kata.model.enums.DeliveryMode;
import com.example.kata.model.po.Reservation;
import com.example.kata.model.po.User;
import com.example.kata.model.vo.ReservationRequest;
import com.example.kata.model.vo.ReservationResponse;
import com.example.kata.model.vo.UserRequest;
import com.example.kata.repository.ReservationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @Mock
    private UserService userService;

    @Mock
    private ReservationMapper mapper;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddReservation() {

        // Given
        User user = new User(1l, "username", "email@email.com", "password");
        UserRequest userRequest = new UserRequest(1L, "username", "email@email.com");

        ReservationRequest reservationRequest = new ReservationRequest();
        reservationRequest.setDeliveryMode(DeliveryMode.DELIVERY_ASAP);
        reservationRequest.setUser(userRequest);

        Reservation reservation = new Reservation();
        reservation.setDeliveryTime(LocalDateTime.now());
        reservation.setUser(user);

        when(mapper.mapToReservation(any())).thenReturn(reservation);
        when(userService.findByUserName("username")).thenReturn(user);
        when(reservationRepository.save(any())).thenReturn(reservation);

        // When
        ReservationResponse response = reservationService.addReservation(reservationRequest);

        // Then
        verify(mapper, times(1)).mapToReservation(any());
        verify(userService, times(1)).findByUserName("username");
        verify(reservationRepository, times(1)).save(any());

    }

    @Test
    public void testGetAllReservations() {
        // Given
        List<Reservation> reservations = new ArrayList<>();
        Reservation reservation = new Reservation();
        reservations.add(reservation);

        when(reservationRepository.findByUserId(1L, PageRequest.of(0, 10)))
                .thenReturn(new PageImpl<>(reservations));

        ReservationResponse reservationResponse = new ReservationResponse();
        when(mapper.mapToReservationResponse(reservation)).thenReturn(reservationResponse);

        // When
        List<ReservationResponse> responseList = reservationService.getAllReservations(1L, PageRequest.of(0, 10));

        // Then
        assertEquals(1, responseList.size());
    }
}
