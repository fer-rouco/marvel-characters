package com.marvel.server.modules.serviceLog;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceLogRepository extends CrudRepository<ServiceLog, Long>  {
    
}
