package com.marvel.server.modules.session;

import org.springframework.stereotype.Service;

import com.marvel.server.modules.session.exceptions.InvalidPasswordResponseException;
import com.marvel.server.modules.session.exceptions.UserNotFoundResponseException;
import com.marvel.server.modules.users.UserDTO;
import com.marvel.server.utils.StringUtils;

@Service
public class LoginService {
  
  public SessionInfoDTO doLogin(UserDTO user, String password) throws UserNotFoundResponseException, InvalidPasswordResponseException {
    if (user == null) {
      throw new UserNotFoundResponseException();
    }

    if (user != null && password.compareTo(StringUtils.fromSha256(user.getPassword())) != 0) {
      throw new InvalidPasswordResponseException();
    }

    SessionInfoDTO sessionInfo = new SessionInfoDTO();
    sessionInfo.setUserName(user.getUserName()); 
    sessionInfo.generateNewToken();
    
    return sessionInfo;
  }
  
}
