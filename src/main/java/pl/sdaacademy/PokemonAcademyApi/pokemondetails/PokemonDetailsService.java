package pl.sdaacademy.PokemonAcademyApi.pokemondetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.PokemonRepository;

@Service
public class PokemonDetailsService {
    private final PokemonRepository pokemonRepository;

    @Autowired
    public PokemonDetailsService(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    public Pokemon getPokemonDetails(String pokemonName) {
        Pokemon pokemon = pokemonRepository.findByName(pokemonName).orElseThrow(()->{
            return new NoPokemonFoundException(pokemonName);
        });
        return pokemon;
    }

}
