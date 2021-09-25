package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonListService {
    private final PokemonRepository pokemonRepository;
    private final PokemonListNetworkRepository pokemonListNetworkRepository;

    @Autowired
    public PokemonListService(PokemonRepository pokemonRepository, PokemonListNetworkRepository pokemonListNetworkRepository) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonListNetworkRepository = pokemonListNetworkRepository;
    }

    public List<Pokemon> getPokemonList() {
        if (pokemonRepository.count() != 0) {
            return pokemonRepository.findAll();
        }
        final List<Pokemon> pokemons = new ArrayList<>();
        int offset = 0;
        int limit = 100;
        PokemonListResult pokemonListResult;
        do {
            pokemonListResult = pokemonListNetworkRepository.fetchPokemonList(offset, limit);
            pokemonListResult.getResults().forEach(pokemon -> {
                String[] urlData = pokemon.getUrl().split("/");
                pokemon.setId(Integer.parseInt(urlData[urlData.length-1]));
            });
            pokemons.addAll(pokemonListResult.getResults());
            offset+=limit;
        } while (pokemonListResult.getNext() != null);
        pokemonRepository.saveAll(pokemons);
        return pokemons;
    }
}
