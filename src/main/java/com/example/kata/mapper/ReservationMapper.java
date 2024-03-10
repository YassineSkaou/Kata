package com.example.kata.mapper;

import com.example.kata.model.po.Reservation;
import com.example.kata.model.po.User;
import com.example.kata.model.vo.ReservationRequest;
import com.example.kata.model.vo.ReservationResponse;
import com.example.kata.model.vo.UserResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ReservationMapper {

    Reservation mapToReservation(ReservationRequest reservationRequest);

    ReservationResponse mapToReservationResponse(Reservation reservation);

    UserResponse mapToUserResponse(User user);
}
