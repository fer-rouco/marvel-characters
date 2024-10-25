package com.marvel.api.client.dtos;
import java.util.Date;
import java.util.List;

import lombok.Data;


@Data
public class MarvelCharacterDTO {
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