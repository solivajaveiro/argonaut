package br.com.bep.persona.service;

import br.com.bep.persona.dto.CharacterDTO;
import br.com.bep.persona.repository.CharacterRepository;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CharacterServiceTest {

    @Autowired
    private CharacterService characterService;

    @Autowired
    private CharacterRepository characterRepository;

    @BeforeAll
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.bep.persona.fixture");
    }

    @Test
    public void shouldCreateCharacter() {
        CharacterDTO valid = Fixture.from(CharacterDTO.class).gimme("valid");

        CharacterDTO characterDTO = characterService.save(valid);

        assertNotNull(characterDTO);
        assertNotNull(characterDTO.getName(), valid.getName());
    }

    @Test
    public void shouldFindByIdCharacter() {
        CharacterDTO characterDTO = characterService.getOne("1");

        assertNotNull(characterDTO.getId());
    }

    @Test
    public void shouldUpdateCharacter() {
        CharacterDTO valid = Fixture.from(CharacterDTO.class).gimme("valid");

        CharacterDTO oneTwo = characterService.getOne("1");

        characterService.update(oneTwo.getId(), valid).get();

        assertNotNull(oneTwo);

    }
}
