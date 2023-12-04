package com.marvel.server.modules.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.server.modules.session.exceptions.InvalidPasswordResponseException;
import com.marvel.server.modules.session.exceptions.UserNotFoundResponseException;
import com.marvel.server.modules.users.User;
import com.marvel.server.modules.users.UserDTO;
import com.marvel.server.modules.users.UserService;

@RestController
@RequestMapping("/session")
public class SessionController {
  @Autowired
  LoginService loginService;

  @Autowired
  UserService userService;

  @GetMapping(path = "/login")
  public ResponseEntity<SessionInfoDTO> login(@RequestParam(User.Fields.userName) String userOrMail, @RequestParam(User.Fields.password) String password) {
    ResponseEntity<SessionInfoDTO> response = null;

    UserDTO user = (!userOrMail.contains("@")) ? userService.findByUserName(userOrMail) : userService.findByMail(userOrMail);
    try {
      response = ResponseEntity.status(HttpStatus.OK).body(loginService.doLogin(user, password));
    }
    catch (UserNotFoundResponseException responseException) {
      response = ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }
    catch (InvalidPasswordResponseException responseException) {
      response = ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    }

    return response;
  }

}
