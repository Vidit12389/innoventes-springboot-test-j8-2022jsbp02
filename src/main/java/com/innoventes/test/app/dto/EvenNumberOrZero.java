package com.innoventes.test.app.dto;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EvenNumberOrZeroValidator.class)
@Target({ElementType.FIELD} )
@Retention(RetentionPolicy.RUNTIME)
public @interface EvenNumberOrZero {
    String message() default "Value must be an evem number or zero";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};

}
