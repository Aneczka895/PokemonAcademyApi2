package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonListService {
    private final PokemonListNetworkRepository pokemonListNetworkRepository;

    @Autowired
    public PokemonListService(PokemonListNetworkRepository pokemonListNetworkRepository) {
        this.pokemonListNetworkRepository = pokemonListNetworkRepository;
    }

    public List<Pokemon> getPokemonList() {
        final List<Pokemon> pokemons = new ArrayList<>();
        int offset = 0;
        int limit = 100;
        PokemonListResult pokemonListResult;
        do {
            pokemonListResult = pokemonListNetworkRepository.fetchPokemonList(offset, limit);
            pokemons.addAll(pokemonListResult.getResults());
            offset+=limit;
        } while (pokemonListResult.getNext() != null);
        return pokemons;
    }
}
