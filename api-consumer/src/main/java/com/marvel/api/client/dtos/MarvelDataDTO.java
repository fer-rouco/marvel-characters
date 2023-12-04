package com.marvel.api.client.dtos;

import lombok.Data;
import java.util.List;

@Data
class MarvelDataDTO {
    private int offset;
    private int limit;
    private int total;
    private int count;
    private List<MarvelCharacterDTO> results;
}
