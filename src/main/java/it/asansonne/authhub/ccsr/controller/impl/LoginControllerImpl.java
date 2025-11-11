package it.asansonne.authhub.ccsr.controller.impl;

import it.asansonne.authhub.ccsr.component.UserComponent;
import it.asansonne.authhub.ccsr.controller.LoginController;
import it.asansonne.authhub.dto.request.UserRequest;
import it.asansonne.authhub.dto.response.UserResponse;
import it.asansonne.management.enumeration.KingdomName;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import java.util.Locale;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.support.RequestContextUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequiredArgsConstructor
public class LoginControllerImpl implements LoginController {

  private final UserComponent userComponent;
  private final MessageSource messageSource;

  @GetMapping("/login")
  public String login() {
    return "login";
  }

  @GetMapping("/welcome")
  public String welcome(@RequestParam(name="name", defaultValue="User") String name,
                        HttpServletRequest request,
                        Model model) {
    Locale locale = RequestContextUtils.getLocale(request);
    String message = messageSource.getMessage(KingdomName.CORONOR.getMaxim(), new Object[]{name}, locale);
    model.addAttribute("message", message);
    model.addAttribute("name", name);
    return "login";
  }


  @Override
  @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public ResponseEntity<UserResponse> createPerson(
      @Valid @RequestBody UserRequest personRequest,
      UriComponentsBuilder builder
  ) {
    UserResponse response = userComponent.createPerson(personRequest);
    return ResponseEntity
        .created(builder
            .path(String.format("%s/%s/admin/", API, API_VERSION))
            .buildAndExpand(response.getUuid().toString())
            .toUri()
        ).body(response);
  }
}

