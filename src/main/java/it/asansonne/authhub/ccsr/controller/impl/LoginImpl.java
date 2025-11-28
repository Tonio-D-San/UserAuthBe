package it.asansonne.authhub.ccsr.controller.impl;

import it.asansonne.authhub.ccsr.controller.Login;
import org.springframework.web.bind.annotation.GetMapping;

public class LoginImpl implements Login {
  @GetMapping("/login")
  public String login() {
    return "login";
  }
}
