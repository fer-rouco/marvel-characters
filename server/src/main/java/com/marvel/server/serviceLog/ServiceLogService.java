package com.marvel.server.serviceLog;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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
    
    public List<ServiceLogDTO> findAll() {
        Iterable<ServiceLog> entities = repository.findAll();
        List<ServiceLogDTO> mappingDTOs = ((Collection<ServiceLog>) entities).stream()
            .map(entity -> modelMapper.map(entity, ServiceLogDTO.class))
            .collect(Collectors.toList());
        return mappingDTOs;
    }

    
}
