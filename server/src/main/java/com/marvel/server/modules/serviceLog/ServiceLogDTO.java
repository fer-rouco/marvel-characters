package com.marvel.server.modules.serviceLog;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ServiceLogDTO {
    private Long id;
    private String path;
    private String userName;
    private LocalDateTime dateTime;

    public String getDateTime() {
        return dateTime.toString();
    }
}
