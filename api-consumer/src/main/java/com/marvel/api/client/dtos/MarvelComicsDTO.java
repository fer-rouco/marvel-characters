package com.marvel.api.client.dtos;

import java.util.List;

import lombok.Data;

@Data
public class MarvelComicsDTO {
    private int available;
    private int returned;
    private String collectionURI;
    private List<MarvelItemDTO> items;
}
