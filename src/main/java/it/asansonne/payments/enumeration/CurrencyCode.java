package it.asansonne.payments.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

//three-character ISO-4217
@Getter
@AllArgsConstructor
public enum CurrencyCode {
  AUSTRALIAN_DOLLAR("Australian Dollar", "AUD", ""),
  BRAZILIAN_REAL("Brazilian Real", "BRL", ""),
  CANADIAN_DOLLAR("Canadian Dollar", "CAD", ""),
  CHINESE_RENMINBI("Chinese renminbi", "CNY", ""),
  CZECH_KORUNA("Czech Koruna", "CZK", ""),
  DANISH_KRONE("Danish Krone", "DKK", ""),
  EURO("Euro", "EUR", ""),
  HONG_KONG_DOLLAR("Hong Kong Dollar", "HKD", ""),
  HUNGARIAN_FORINT("Hungarian Forint", "HUF",
      Constants.NO_DECIMAL_CURRENCY),
  ISRAELI_NEW_SHEKEL("Israeli New Shekel", "ILS", ""),
  JAPANESE_YEN("Japanese Yen", "JPY", Constants.NO_DECIMAL_CURRENCY),
  MALAYSIAN_RINGGIT("Malaysian Ringgit", "MYR", ""),
  MEXICAN_PESO("Mexican Peso", "MXN", ""),
  NEW_TAIWAN_DOLLAR("New Taiwan Dollar", "TWD",
      Constants.NO_DECIMAL_CURRENCY),
  NEW_ZEALAND_DOLLAR("New Zealand Dollar", "NZD", ""),
  NORWEGIAN_KRONE("Norwegian Krone", "NOK", ""),
  PHILIPPINE_PESO("Philippine Peso", "PHP", ""),
  POLISH_ZLOTY("Polish Złoty", "PLN", ""),
  POUND_STERLING("Pound Sterling", "GBP", ""),
  SINGAPORE_DOLLAR("Singapore Dollar", "SGD", ""),
  SWEDISH_KRONA("Swedish Krona", "SEK", ""),
  SWISS_FRANC("Swiss Franc", "CHF", ""),
  THAI_BAHT("Thai Baht", "THB", ""),
  UNITED_STATES_DOLLAR("United States Dollar", "USD", "")
;

  private final String currency;
  private final String code;
  private final String notes;

  private static class Constants {
    public static final String NO_DECIMAL_CURRENCY =
        "currency.no-decimal.description";
  }
}
