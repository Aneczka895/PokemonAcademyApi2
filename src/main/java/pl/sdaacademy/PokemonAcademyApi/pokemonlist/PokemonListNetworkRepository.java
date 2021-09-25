package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokemonListNetworkRepository {

    private final String URL_FORMAT = "https://pokeapi.co/api/v2/pokemon/?offset=%d&limit=%d";

    public PokemonListResult fetchPokemonList(int offset, int limit) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(URL_FORMAT, offset, limit);
        return restTemplate.getForObject(url, PokemonListResult.class);
    }
}
