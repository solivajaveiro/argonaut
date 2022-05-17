package br.com.bep.persona.service;

import br.com.bep.persona.dto.CharacterDTO;
import br.com.bep.persona.exceptions.EntityNotFoundException;
import br.com.bep.persona.model.Character;

import br.com.bep.persona.repository.CharacterRepository;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CharacterService {

    @Autowired
    private ModelMapper mapper;
    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.mapper = new ModelMapper();
        mapper.typeMap(CharacterDTO.class, Character.class).setPropertyCondition(Conditions.isNotNull());
        mapper.getConfiguration().setSkipNullEnabled(true);
        this.characterRepository = characterRepository;
    }

    @Transactional
    public CharacterDTO save(CharacterDTO characterDTO) {
        createdUniqueServerHash(characterDTO);
        Character character = mapper.map(characterDTO, Character.class);

        return mapper.map(characterRepository.save(character), CharacterDTO.class);
    }

    private void createdUniqueServerHash(CharacterDTO characterDTO) {
        LocalDateTime localDateTime = LocalDateTime.now();
        String dataFormatada = localDateTime.toString();
        dataFormatada = dataFormatada
                .replace(":", "")
                            .replace("-", "").replace(".", "");

        String nameFormat = characterDTO.getName().substring(0, 3);
        String nameTribeFormat = characterDTO.getTribe().getName().substring(0, 3 );
        characterDTO.setUniqueServerHash(nameFormat.concat(dataFormatada).concat(nameTribeFormat));
    }

    @Transactional(readOnly = true)
    public CharacterDTO getOne(String id) {
        return mapper.map(characterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found")), CharacterDTO.class);
    }

    @Transactional
    public CharacterDTO update(String id, CharacterDTO characterDTO) {
        Character character = characterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Id not found"));

        mapper.map(characterDTO, character);
        character = characterRepository.save(character);
        CharacterDTO charDTO = new CharacterDTO();
        return mapper.map(character, CharacterDTO.class);
    }
}
