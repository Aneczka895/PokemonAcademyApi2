package pl.sdaacademy.PokemonAcademyApi.pokemondetails;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class PokemonDetailsTransformer {

    PokemonDetails toEntity(PokemonDetailsResponse response) {
        PokemonDetails pokemonDetails = new PokemonDetails();
        pokemonDetails.setName(response.getName());
        pokemonDetails.setImageUrl(response.getSprites().getImage());
        pokemonDetails.setHeight(response.getHeight());
        pokemonDetails.setWeight(response.getWeight());
        pokemonDetails.setAbilities(response.getAbilities().stream()
                .map(Abilities::getAbility)
                .map(AbilityItem::getName)
                .collect(Collectors.toList()));
        pokemonDetails.setTypes(response.getTypes().stream()
                .map(Types::getType)
                .map(Type::getName)
                .collect(Collectors.toList()));
        return pokemonDetails;
    }

}
