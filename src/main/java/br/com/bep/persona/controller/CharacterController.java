package br.com.bep.persona.controller;

import br.com.bep.persona.dto.CharacterDTO;
import br.com.bep.persona.service.CharacterService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/character")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public ResponseEntity<CharacterDTO> saveCharacter(@RequestBody @Valid CharacterDTO characterDto) {
        return new ResponseEntity<>(characterService.save(characterDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getOne(@PathVariable(value = "id") String id) {
        CharacterDTO characterDTO = characterService.getOne(id);
        return ResponseEntity.status(HttpStatus.OK).body(characterDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CharacterDTO> update(@PathVariable(value = "id") String id, @RequestBody @Valid CharacterDTO characterDto) {
        CharacterDTO dto = characterService.update(id, characterDto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
    }
}
