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
    private CharacterService service;

    @GetMapping()
    public ResponseEntity<MarvelApiResponseDTO> findAll() {
        return new ResponseEntity<MarvelApiResponseDTO>(service.findAll(), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{characterId}")
    public ResponseEntity<MarvelApiResponseDTO> findById(@PathVariable("characterId") Integer characterId) {
        return new ResponseEntity<MarvelApiResponseDTO>(service.findById(characterId), HttpStatus.OK);
    }
}
