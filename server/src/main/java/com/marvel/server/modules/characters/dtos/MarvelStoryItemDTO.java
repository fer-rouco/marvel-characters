package com.marvel.server.modules.characters.dtos;
import lombok.Data;

@Data
class MarvelStoryItemDTO {
    private String resourceURI;
    private String name;
    private String type;
}