package br.com.bep.persona.dto;

import com.google.code.beanmatchers.BeanMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
public class TribeDTOTest {

    @Test
    public void TribeTest() {
        MatcherAssert.assertThat(TribeDTOTest.class, Matchers.allOf(BeanMatchers.hasValidGettersAndSetters()));
    }
}
