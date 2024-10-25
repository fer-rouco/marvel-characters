package com.marvel.api.client.dtos;

import lombok.Data;

@Data
public class MarvelItemDTO implements MarvelItemInterface {
    private String resourceURI;
    private String name;
}