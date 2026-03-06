package it.asansonne.blog.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = SlugMustBeAbsentValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface SlugMustBeAbsent {
  String message() default "Tag request must not contain slug";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
