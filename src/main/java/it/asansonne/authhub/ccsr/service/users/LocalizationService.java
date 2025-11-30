package it.asansonne.authhub.ccsr.service.users;

import it.asansonne.authhub.model.Models;
import java.util.Locale;

/**
 * The interface Request mapper.
 *
 * @param <M> Model parameter
 */
public interface LocalizationService<M extends Models> {
  String getLocalizedName(M model, Locale locale);
  String getLocalizedDescription(M model, Locale locale);
}
