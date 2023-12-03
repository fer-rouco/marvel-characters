package com.marvel.server.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.server.characters.dtos.MarvelApiResponseDTO;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService characterService;

    @GetMapping()
    public ResponseEntity<MarvelApiResponseDTO> getCharacters() {
        return new ResponseEntity<MarvelApiResponseDTO>(characterService.getAllCharacters(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{characterId}")
    public ResponseEntity<MarvelApiResponseDTO> getCharacters(@PathVariable("characterId") Integer characterId) {
        return new ResponseEntity<MarvelApiResponseDTO>(characterService.getCharacterById(characterId), HttpStatus.OK);
    }
}
