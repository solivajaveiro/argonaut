package br.com.bep.persona.fixture;

import br.com.bep.persona.dto.CharacterDTO;
import br.com.bep.persona.dto.CharacterDTOTest;
import br.com.bep.persona.dto.TribeDTO;
import br.com.bep.persona.dto.TribeDTOTest;
import br.com.bep.persona.model.Character;
import br.com.bep.persona.model.Tribe;
import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class CharacterTemplateLoader implements TemplateLoader {

    @Override
    public void load() {
        Fixture.of(CharacterDTO.class).addTemplate("valid", new Rule(){{

            add("name", "michel");
            add("tribe", one(TribeDTO.class, "tribeDTO-valid"));
            add("active", true);

        }});

        Fixture.of(Character.class).addTemplate("valid-character", new Rule(){{

            add("id", "1");
            add("name", "michel");
            add("tribe", one(Tribe.class, "tribe-valid"));
            add("active", true);

        }});

        Fixture.of(Tribe.class).addTemplate("tribe-valid", new Rule(){{
            add("code", 1);
            add("name", "fuzao");
        }});

        Fixture.of(TribeDTO.class).addTemplate("tribeDTO-valid", new Rule(){{
            add("code", 1);
            add("name", "fuzao");
        }});
    }
}
