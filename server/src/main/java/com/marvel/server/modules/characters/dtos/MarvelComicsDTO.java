package com.marvel.server.modules.characters.dtos;

import lombok.Data;
import java.util.List;

@Data
class MarvelComicsDTO {
    private int available;
    private int returned;
    private String collectionURI;
    private List<MarvelItemDTO> items;
}
