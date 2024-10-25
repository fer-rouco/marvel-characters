package com.marvel.server.modules.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.marvel.api.client.MarvelApiClient;
import com.marvel.api.client.MarvelApiUrlBuilder;
import com.marvel.api.client.dtos.MarvelApiResponseDTO;
import com.marvel.server.modules.characters.event.CharacterEventPublisher;

@Service
public class CharacterService {
    @Autowired
    MarvelApiClient apiClient;

    @Autowired
    CharacterEventPublisher eventPublisher;

    public void publishEvent(String userName, String path) {
        this.eventPublisher.publishCharacterEvent(userName, path);
    }

    public MarvelApiResponseDTO findAll(String userName) {
        this.publishEvent(userName, "/characters");
        return new Gson().fromJson(apiClient.getCharacters(), MarvelApiResponseDTO.class);
    }

    public MarvelApiResponseDTO findById(String userName, int characterId) {
        this.publishEvent(userName, "/characters/" + characterId);
        MarvelApiResponseDTO marvelApiResponseDTO = new Gson().fromJson(apiClient.getCharacterById(characterId), MarvelApiResponseDTO.class);
        marvelApiResponseDTO.getData().getResults().forEach(result -> {
            MarvelApiUrlBuilder.buildUrlFromItems(result.getComics().getItems());
            MarvelApiUrlBuilder.buildUrlFromItems(result.getSeries().getItems());
            MarvelApiUrlBuilder.buildUrlFromItems(result.getStories().getItems());
        });
        return marvelApiResponseDTO;
    }

}
