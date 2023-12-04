package com.marvel.server.modules.characters.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.marvel.server.modules.serviceLog.ServiceLogService;

@Component
public class CharacterEventListener {
    @Autowired
    private ServiceLogService serviceLogService;
    
    @EventListener
    public void handleServiceMethodCalledEvent(CharacterEvent event) {
        // Handle the event
        String path = event.getPath();

        System.out.println("Service method called event received! Method: " + path);

        serviceLogService.log(event.getPath());
    }
}
