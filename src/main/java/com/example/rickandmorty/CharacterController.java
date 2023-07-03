package com.example.rickandmorty;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/rickandmorty")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService service;

    @GetMapping
    RickMortyCharacter getCharacters(){
        return service.getCharacter14();
    }

    @GetMapping("/list")
    List<RickMortyCharacter> listCharacters(){
        return service.listCharacters();
    }

    @GetMapping("/random")
    public RickMortyCharacter getRandomCharacters(){
        return service.getRandomCharacter();
    }










}
