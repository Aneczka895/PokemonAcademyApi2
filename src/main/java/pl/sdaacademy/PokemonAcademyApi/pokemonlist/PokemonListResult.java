package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import java.util.List;

public class PokemonListResult {
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }
}
