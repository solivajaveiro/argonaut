package br.com.bep.persona.dto;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

public class CharacterDTOTest {

    @Test
    public void characterTest() {
        MatcherAssert.assertThat(CharacterDTOTest.class, Matchers.allOf(BeanMatchers.hasValidGettersAndSetters()));
    }
}
