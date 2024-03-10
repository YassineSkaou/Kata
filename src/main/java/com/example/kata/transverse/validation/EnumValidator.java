package com.example.kata.transverse.validation;

import com.example.kata.transverse.validation.impl.EnumValidatorImpl;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = EnumValidatorImpl.class)
public @interface EnumValidator {

    Class<? extends Enum<?>> enumClass();

    String message() default "La valeur n'est pas valide";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
