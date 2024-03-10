package com.example.kata.transverse.validation.impl;

import com.example.kata.model.enums.DeliveryMode;
import com.example.kata.transverse.validation.EnumValidator;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EnumValidatorImpl implements ConstraintValidator<EnumValidator, DeliveryMode> {

    private List<String> acceptedValues;

    @Override
    public void initialize(EnumValidator annotation) {

        acceptedValues = Stream.of(annotation.enumClass().getEnumConstants())
                .map(Enum::name)
                .collect(Collectors.toList());
    }

    @Override
    public boolean isValid(DeliveryMode value, ConstraintValidatorContext constraintValidatorContext) {
        return value != null && acceptedValues.contains(value.toString());
    }

}
