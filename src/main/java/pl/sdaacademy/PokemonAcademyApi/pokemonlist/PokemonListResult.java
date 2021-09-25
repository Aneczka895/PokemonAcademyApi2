package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import java.util.List;

public class PokemonListResult {
    private String next;
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }
}
