package com.innoventes.test.app.dto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EvenNumberOrZeroValidator implements ConstraintValidator<EvenNumberOrZero, Number> {

    @Override
    public boolean isValid(Number value, ConstraintValidatorContext context) {
        return value== null || value.longValue() == 0 || value.longValue() %2 == 0;
    }
}
