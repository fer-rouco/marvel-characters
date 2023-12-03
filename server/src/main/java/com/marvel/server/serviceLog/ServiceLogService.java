package com.marvel.server.serviceLog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ServiceLogService {
    @Autowired
    private ServiceLogRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void log(String path) {
        ServiceLog serviceLog = new ServiceLog();
        
        serviceLog.setDateTime(LocalDateTime.now());
        serviceLog.setPath(path);
        serviceLog.setUserName(null);

        repository.save(serviceLog);
    }
    
    public ServiceLogDTO findAll() {
        return modelMapper.map(repository.findAll(), ServiceLogDTO.class);
    }

    
}
