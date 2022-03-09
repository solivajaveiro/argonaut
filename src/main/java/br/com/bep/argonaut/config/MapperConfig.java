package br.com.bep.argonaut.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    public ModelMapper mapper() {
        return new ModelMapper();
    }
}
