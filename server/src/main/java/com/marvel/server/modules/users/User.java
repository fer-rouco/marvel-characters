package com.marvel.server.modules.users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldNameConstants;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@FieldNameConstants
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 30)
  private String name;
  @Column(length = 30)
  private String lastName;
  @Column(nullable = false, unique = true)
  private String userName;
  @Column(nullable = false, unique = true)
  private String mail;
  @Column(nullable = false)
  private byte[] password;

}
