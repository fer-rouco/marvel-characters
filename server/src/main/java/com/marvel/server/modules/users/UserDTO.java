package com.marvel.server.modules.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@Builder
public class UserDTO {

  private Long id;
  private String name;
  private String lastName;
  private String userName;
  private String mail;
  private byte[] password;
  
}
