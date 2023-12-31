package com.marvel.server.modules.session;

import com.marvel.server.utils.StringUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@FieldNameConstants
public class SessionInfoDTO {
  private Long id;
  private String token;
  private String userName;

  public void generateNewToken() {
    this.setToken(StringUtils.generateNewToken());
  }

}

