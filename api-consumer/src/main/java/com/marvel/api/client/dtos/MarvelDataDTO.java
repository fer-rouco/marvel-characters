package com.marvel.api.client.dtos;

import java.util.List;

import lombok.Data;

@Data
public class MarvelDataDTO {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<MarvelCharacterDTO> results;
}
