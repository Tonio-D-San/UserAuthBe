package it.asansonne.blog.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = BlogTagSelectorValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidBlogTagSelector {
  String message() default "Invalid tag selector. Use only uuid OR only name OR only slug OR name+slug.";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
