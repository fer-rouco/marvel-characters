package com.marvel.server.serviceLog;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ServiceLogDTO {
    private Long id;
    private String path;
    private Long userName;
    private LocalDateTime dateTime;

    public String getDateTime() {
        return dateTime.toString();
    }
}
