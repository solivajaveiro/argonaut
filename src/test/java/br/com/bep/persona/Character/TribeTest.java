package br.com.bep.persona.Character;

import br.com.bep.persona.model.Character;
import br.com.bep.persona.model.Tribe;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import static com.google.code.beanmatchers.BeanMatchers.*;

public class TribeTest {

    @Test
    public void TribeTest() {
        MatcherAssert.assertThat(Tribe.class, Matchers
                .allOf(hasValidGettersAndSetters(),
                        hasValidBeanConstructor(),
                        hasValidBeanEquals(),
                        hasValidBeanHashCode(),
                        hasValidBeanToString()));
    }
}
