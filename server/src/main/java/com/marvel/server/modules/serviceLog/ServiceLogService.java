package com.marvel.server.modules.serviceLog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceLogService {
    @Autowired
    private ServiceLogRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public void log(String userName, String path) {
        ServiceLog serviceLog = new ServiceLog();
        
        serviceLog.setDateTime(LocalDateTime.now());
        serviceLog.setPath(path);
        serviceLog.setUserName(userName);

        repository.save(serviceLog);
    }
    
    public List<ServiceLogDTO> findAll(String userName) {
        List<ServiceLog> entities = repository.findAllByUserName(userName);
        List<ServiceLogDTO> mappingDTOs = entities.stream()
            .map(entity -> modelMapper.map(entity, ServiceLogDTO.class))
            .collect(Collectors.toList());
        return mappingDTOs;
    }

    
}
