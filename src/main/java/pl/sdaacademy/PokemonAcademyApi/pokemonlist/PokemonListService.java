package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonListService {
    private final PokemonListNetworkRepository pokemonListNetworkRepository;

    @Autowired
    public PokemonListService(PokemonListNetworkRepository pokemonListNetworkRepository) {
        this.pokemonListNetworkRepository = pokemonListNetworkRepository;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonListNetworkRepository.fetchPokemonList().getResults();
    }
}
