package com.marvel.api.client.dtos;
import lombok.Data;

import java.util.Date;
import java.util.List;


@Data
class MarvelCharacterDTO {
    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List<MarvelUrlDTO> urls;
    private MarvelThumbnailDTO thumbnail;
    private MarvelComicsDTO comics;
    private MarvelStoriesDTO stories;
    private MarvelEventsDTO events;
    private MarvelSeriesDTO series;
}