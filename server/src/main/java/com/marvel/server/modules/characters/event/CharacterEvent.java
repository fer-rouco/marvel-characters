package com.marvel.server.modules.characters.event;

import org.springframework.context.ApplicationEvent;

public class CharacterEvent extends ApplicationEvent {

    private final String path;

    public CharacterEvent(Object source, String path) {
        super(source);
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}