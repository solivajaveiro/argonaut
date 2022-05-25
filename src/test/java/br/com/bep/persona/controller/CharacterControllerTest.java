package br.com.bep.persona.controller;

import br.com.bep.persona.dto.CharacterDTO;
import br.com.bep.persona.dto.CharacterDTOTest;
import br.com.bep.persona.model.Character;
import br.com.bep.persona.repository.CharacterRepository;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@AutoConfigureMockMvc
@SpringBootTest
public class CharacterControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CharacterRepository characterRepository;

    private Integer id;

    @BeforeAll
    public static void setUp() {
        FixtureFactoryLoader.loadTemplates("br.com.bep.persona.fixture");

    }

    @Test
    public void shouldCreateCharacter() throws Exception {

        CharacterDTO valid = Fixture.from(CharacterDTO.class).gimme("valid");

        String obj = objectMapper.writeValueAsString(valid);

        mockMvc.perform(
                        MockMvcRequestBuilders.post("/character")
                                .header(HttpHeaders.AUTHORIZATION, "Bearer aa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(obj))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void shouldFindGetOne() throws Exception {

        Character obj = Fixture.from(Character.class).gimme("valid-character");

        Character charac = characterRepository.save(obj);

        mockMvc.perform(
                        MockMvcRequestBuilders.get("/character/{id}", charac.getId())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer aa"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void shouldUpdateCharacter() throws Exception {

        Character obj = Fixture.from(Character.class).gimme("valid-character");

        Character charac = characterRepository.save(obj);

        String objeto = objectMapper.writeValueAsString(charac);

        mockMvc.perform(
                        MockMvcRequestBuilders.put("/character/{id}", charac.getId())
                                .header(HttpHeaders.AUTHORIZATION, "Bearer aa")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(objeto))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
