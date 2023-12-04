package com.marvel.server.modules.characters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.api.client.dtos.MarvelApiResponseDTO;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    @Autowired
    private CharacterService service;

    @GetMapping("/{userName}")
    public ResponseEntity<MarvelApiResponseDTO> findAll(@PathVariable("userName") String userName) {
        return new ResponseEntity<MarvelApiResponseDTO>(service.findAll(userName), HttpStatus.OK);
    }
    
    @GetMapping(path = "/{userName}/{characterId}")
    public ResponseEntity<MarvelApiResponseDTO> findById(@PathVariable("userName") String userName, @PathVariable("characterId") Integer characterId) {
        return new ResponseEntity<MarvelApiResponseDTO>(service.findById(userName, characterId), HttpStatus.OK);
    }
}
