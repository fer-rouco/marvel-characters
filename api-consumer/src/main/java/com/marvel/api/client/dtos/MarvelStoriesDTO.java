package com.marvel.api.client.dtos;

import lombok.Data;
import java.util.List;

@Data
class MarvelStoriesDTO {
    private int available;
    private int returned;
    private String collectionURI;
    private List<MarvelStoryItemDTO> items;
}