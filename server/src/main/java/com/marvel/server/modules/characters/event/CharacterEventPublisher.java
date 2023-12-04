package com.marvel.server.modules.characters.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CharacterEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    public CharacterEventPublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void publishCharacterEvent(String path) {
        CharacterEvent event = new CharacterEvent(this, path);
        eventPublisher.publishEvent(event);
    }
}