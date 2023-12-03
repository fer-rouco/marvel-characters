package com.marvel.server.serviceLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/event-log")
public class ServiceLogController {
    @Autowired
    private ServiceLogService service;


    @GetMapping()
    public ResponseEntity<ServiceLogDTO> findAll() {
        return new ResponseEntity<ServiceLogDTO>(service.findAll(), HttpStatus.OK);
    }
}
