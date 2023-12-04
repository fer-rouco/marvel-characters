package com.marvel.server.modules.serviceLog;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service-log")
public class ServiceLogController {
    @Autowired
    private ServiceLogService service;

    @GetMapping("/{userName}")
    public ResponseEntity<List<ServiceLogDTO>> findAll(@PathVariable("userName") String userName) {
        return new ResponseEntity<List<ServiceLogDTO>>(service.findAll(userName), HttpStatus.OK);
    }
}
