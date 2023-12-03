package com.marvel.server.characters.event;

import java.util.Arrays;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CharacterEventListener {
    
    @EventListener
    public void handleServiceMethodCalledEvent(CharacterEvent event) {
        // Handle the event
        String methodName = event.getMethodName();
        Object[] methodParams = event.getMethodParams();

        System.out.println("Service method called event received! Method: " + methodName +
                ", Params: " + Arrays.toString(methodParams));
    }
}
