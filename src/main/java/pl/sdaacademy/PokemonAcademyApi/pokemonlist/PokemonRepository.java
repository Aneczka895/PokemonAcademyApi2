package pl.sdaacademy.PokemonAcademyApi.pokemonlist;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
