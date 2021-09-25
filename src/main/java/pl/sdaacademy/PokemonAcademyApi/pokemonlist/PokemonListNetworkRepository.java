package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class PokemonListNetworkRepository {

    public PokemonListResult fetchPokemonList() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/";
        return restTemplate.getForObject(url, PokemonListResult.class);
    }
}
