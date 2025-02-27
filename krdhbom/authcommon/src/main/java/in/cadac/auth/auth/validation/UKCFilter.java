package in.cadac.auth.auth.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
@Constraint(validatedBy = UKCFilterImpl.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface UKCFilter  {
	String message() default "Invalid value";

    // Groups for categorizing constraints
    Class<?>[] groups() default {};

    // Payload to carry additional information
    Class<? extends Payload>[] payload() default {};
}
