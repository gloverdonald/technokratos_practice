package com.technokratos.validation.annotations;

import com.technokratos.validation.validators.AvailabilityDatesValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AvailabilityDatesValidator.class)
public @interface ValidAvailabilityDates {
    String message() default "invalid date interval";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}