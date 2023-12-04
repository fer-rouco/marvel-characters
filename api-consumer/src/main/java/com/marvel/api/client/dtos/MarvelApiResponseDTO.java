package com.marvel.api.client.dtos;

import lombok.Data;

@Data
public class MarvelApiResponseDTO {
    private int code;
    private String status;
    private String copyright;
    private String attributionText;
    private String attributionHTML;
    private MarvelDataDTO data;
    private String etag;
}
