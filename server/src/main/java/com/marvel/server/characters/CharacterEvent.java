package com.marvel.server.characters;

import org.springframework.context.ApplicationEvent;

public class CharacterEvent extends ApplicationEvent {

    private final String methodName;
    private final Object[] methodParams;

    public CharacterEvent(Object source, String methodName, Object[] methodParams) {
        super(source);
        this.methodName = methodName;
        this.methodParams = methodParams;
    }

    public String getMethodName() {
        return methodName;
    }

    public Object[] getMethodParams() {
        return methodParams;
    }
}