package com.marvel.api.client.dtos;

import java.util.List;

import lombok.Data;

@Data
public class MarvelSeriesDTO {
    private int available;
    private int returned;
    private String collectionURI;
    private List<MarvelItemDTO> items;
}