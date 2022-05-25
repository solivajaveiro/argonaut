package br.com.bep.persona.Character;

import br.com.bep.persona.model.Character;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;

public class CharacterTest {

    @Test
    public void clienteTest() {
        MatcherAssert.assertThat(Character.class, Matchers
                .allOf(hasValidGettersAndSetters(),
                        hasValidBeanConstructor(),
                        hasValidBeanEquals(),
                        hasValidBeanHashCode(),
                        hasValidBeanToString()));
    }
}
