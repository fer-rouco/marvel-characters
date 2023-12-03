package com.marvel.server.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.marvel.api.client.MarvelApiClient;
import com.marvel.server.characters.dtos.MarvelApiResponseDTO;
import com.marvel.server.characters.event.CharacterEventPublisher;

@Service
public class CharacterService {
    @Autowired
    MarvelApiClient apiClient;

    @Autowired
    CharacterEventPublisher eventPublisher;

    public void publishEvent(String methodName, Object[] ... parameters) {
        this.eventPublisher.publishCharacterEvent(methodName, parameters);
    }

    public MarvelApiResponseDTO getAllCharacters() {
        this.publishEvent("getAllCharacters");
        return new Gson().fromJson(apiClient.getCharacters(), MarvelApiResponseDTO.class);
    }

    public MarvelApiResponseDTO getCharacterById(int characterId) {
        this.publishEvent("getCharacterById", new Object[]{ characterId });
        return new Gson().fromJson(apiClient.getCharacterById(characterId), MarvelApiResponseDTO.class);
    }

}
