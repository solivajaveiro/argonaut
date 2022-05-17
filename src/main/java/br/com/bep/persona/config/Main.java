package br.com.bep.persona.config;

import java.time.LocalDateTime;
public class Main {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        String dataFormatada = localDateTime.toString();

        dataFormatada = dataFormatada
                .replace(":", "")
                .replace("-", "")
                .replace(".", "")
                .replace("/", "")
                .replace("T", "");
//""
        String format = dataFormatada.substring(0, 3);

        System.out.println(dataFormatada);

    }
}
