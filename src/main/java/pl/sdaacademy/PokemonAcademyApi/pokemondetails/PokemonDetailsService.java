package pl.sdaacademy.PokemonAcademyApi.pokemondetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.Pokemon;
import pl.sdaacademy.PokemonAcademyApi.pokemonlist.PokemonRepository;

@Service
public class PokemonDetailsService {
    private final PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository;
    private final PokemonRepository pokemonRepository;
    private final PokemonDetailsTransformer pokemonDetailsTransformer;

    @Autowired
    public PokemonDetailsService(PokemonDetailsNetworkRepository pokemonDetailsNetworkRepository,
                                 PokemonRepository pokemonRepository,
                                 PokemonDetailsTransformer pokemonDetailsTransformer) {
        this.pokemonRepository = pokemonRepository;
        this.pokemonDetailsNetworkRepository = pokemonDetailsNetworkRepository;
        this.pokemonDetailsTransformer = pokemonDetailsTransformer;
    }

    /*
    Przygotować strukturę o nazwie PokemonDeatils która upraszczała by dane zwrócone z backendu
     */
    public PokemonDetails getPokemonDetails(String pokemonName) {
        Pokemon pokemon = pokemonRepository.findByName(pokemonName)
                .orElseThrow(() -> new NoPokemonFoundException(pokemonName));
        PokemonDetailsResponse pokemonDetailsResponse = pokemonDetailsNetworkRepository.fetchPokemonDetails(pokemon.getId());
        PokemonDetails pokemonDetails = pokemonDetailsTransformer.toEntity(pokemonDetailsResponse);
        return pokemonDetails;
    }

}
