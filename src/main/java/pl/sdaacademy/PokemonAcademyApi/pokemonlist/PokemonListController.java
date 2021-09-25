package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonListController {

    private final PokemonListService pokemonListService;

    @Autowired
    public PokemonListController(PokemonListService pokemonListService) {
        this.pokemonListService = pokemonListService;
    }

    @GetMapping("/list")
    List<Pokemon> getPokemonList(){
        return pokemonListService.getPokemonList();
    }
}
