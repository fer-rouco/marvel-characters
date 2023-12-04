package com.marvel.server.modules.users;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  @Autowired
  UserRepository userRepository;
  
  @Autowired
  private ModelMapper modelMapper;

  public long countUsers() {
    return userRepository.count();
  }

  // public List<UserDTO> findAll() {
  //   return userConverter.convert(userRepository.findAll());
  // }

  // public UserDTO saveUser(UserDTO userModel) {
  //   return userConverter.convert(userRepository.save(userConverter.convert(userModel)));
  // }

  // public UserDTO findById(Long id) {
  //   return userConverter.convert(userRepository.findById(id));
  // }

  public UserDTO findByUserName(String user) {
    return modelMapper.map(userRepository.findByUserName(user), UserDTO.class);
  }

  public UserDTO findByMail(String mail) {
    return modelMapper.map(userRepository.findByMail(mail), UserDTO.class);
  }

  // public boolean deleteUser(Long id) {
  //   try {
  //     userRepository.deleteById(id);
  //     return true;
  //   }
  //   catch (Exception exception) {
  //     return false;
  //   }
  // }

}
