package com.marvel.server.modules.users;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, JpaSpecificationExecutor<User> {
  public abstract Page<User> findAll(Pageable pageable);
  public abstract Optional<User> findByUserName(String user);
  public abstract Optional<User> findByMail(String mail);  

  
  interface ReducedUser {
    Long   getId();
    String getName();
    String getLastName();
    String getUserName();
    String getMail();
  }
}
