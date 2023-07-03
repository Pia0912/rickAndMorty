package com.example.rickandmorty;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public class CharacterService {
    private final WebClient webClient = WebClient.create("https://rickandmortyapi.com/api/");

    public RickMortyCharacter getCharacter14() {
        ResponseEntity<RickMortyCharacter> responseEntity = webClient.get()
                .uri("character/14")
                .retrieve()
                .toEntity(RickMortyCharacter.class)
                .block();

        return Objects.requireNonNull(responseEntity).getBody();
    }


    public List<RickMortyCharacter> listCharacters() {


        ResponseEntity<CharacterResults> responseEntity = webClient.get()
                .uri("character")
                .retrieve()
                .toEntity(CharacterResults.class)
                .block();

        return Objects.requireNonNull(responseEntity).getBody().results();
    }

    public RickMortyCharacter getRandomCharacter() {
        ResponseEntity<CharacterResults> responseEntity = webClient.get()
                .uri("character")
                .retrieve()
                .toEntity(CharacterResults.class)
                .block();

        CharacterResults randomCharacter = Objects.requireNonNull(responseEntity).getBody();
        List<RickMortyCharacter> listRandomCharacter = randomCharacter.results();

        int totalCharacters = listRandomCharacter.size();
        int randomIndex = new Random().nextInt(totalCharacters);

        return listRandomCharacter.get(randomIndex);
    }
}
