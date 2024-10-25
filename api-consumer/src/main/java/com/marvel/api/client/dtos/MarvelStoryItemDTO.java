package com.marvel.api.client.dtos;
import lombok.Data;

@Data
public class MarvelStoryItemDTO implements MarvelItemInterface {
    private String resourceURI;
    private String name;
    private String type;
}