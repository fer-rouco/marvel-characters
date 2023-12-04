package com.marvel.server.modules.users;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  private ModelMapper modelMapper;

  public UserDTO findByUserName(String user) {
    return modelMapper.map(userRepository.findByUserName(user), UserDTO.class);
  }

  public UserDTO findByMail(String mail) {
    return modelMapper.map(userRepository.findByMail(mail), UserDTO.class);
  }

}
