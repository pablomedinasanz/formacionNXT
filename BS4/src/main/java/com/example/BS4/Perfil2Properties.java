package com.example.BS4;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Configuration
@PropertySource("classpath:perfil2.properties")
@Profile("perfil2")
public class Perfil2Properties implements Perfil{

    @Value("${perfil}")
    private String perfil;

    @Override
    public void miFuncion() {
        System.out.println(perfil);
    }
}
