package com.marvel.server.modules.characters.event;

import org.springframework.context.ApplicationEvent;

public class CharacterEvent extends ApplicationEvent {

    private final String userName;
    private final String path;

    public CharacterEvent(Object source, String userName, String path) {
        super(source);
        this.path = path;
        this.userName = userName;
    }

    public String getPath() {
        return path;
    }
    
    public String getUserName() {
        return userName;
    }
}