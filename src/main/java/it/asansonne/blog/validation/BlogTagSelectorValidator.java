package it.asansonne.blog.validation;

import it.asansonne.blog.dto.request.BlogTagRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BlogTagSelectorValidator implements
    ConstraintValidator<ValidBlogTagSelector, BlogTagRequest> {
  @Override
  public boolean isValid(BlogTagRequest value, ConstraintValidatorContext context) {
    if (value == null) return true;
    boolean hasUuid = value.getUuid() != null;
    boolean hasName = trimToNull(value.getName()) != null;
    boolean hasSlug = trimToNull(value.getSlug()) != null;
    if (hasUuid && !hasName && !hasSlug) return true;
    if (!hasUuid && hasName && hasSlug) return true;
    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(
        "Provide either uuid alone or name+slug (uuid must be absent)."
    ).addConstraintViolation();
    return false;
  }

  private String trimToNull(String s) {
    if (s == null) return null;
    String t = s.trim();
    return t.isEmpty() ? null : t;
  }
}
