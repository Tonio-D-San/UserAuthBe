package it.asansonne.blog.validation;

import it.asansonne.blog.dto.request.BlogTagRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class SlugMustBeAbsentValidator implements
    ConstraintValidator<SlugMustBeAbsent, BlogTagRequest> {
  @Override
  public boolean isValid(BlogTagRequest value, ConstraintValidatorContext context) {
    if (value == null) {
      return true;
    }
    String slug = value.getSlug();
    boolean ok = (slug == null) || slug.isBlank();

    if (!ok) {
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate("Tag request must not contain slug")
          .addPropertyNode("slug")
          .addConstraintViolation();
    }
    return ok;
  }
}
