package com.example.ejercicioDependencias;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreateBean {

    @Bean("bean1")
    public Persona beanPersona1() {
        PersonaService personaService = new PersonaServiceImp();
        personaService.setNombre("bean1");
        personaService.setPoblacion("Alcorcon");
        personaService.setEdad(30);
        return personaService.getPersona();
    }

    @Bean("bean2")
    public Persona beanPersona2() {
        PersonaService personaService = new PersonaServiceImp();
        personaService.setNombre("bean2");
        personaService.setPoblacion("Barcelona");
        personaService.setEdad(33);
        return personaService.getPersona();
    }

    @Bean("bean3")
    public Persona beanPersona3() {
        PersonaService personaService = new PersonaServiceImp();
        personaService.setNombre("bean3");
        personaService.setPoblacion("Malaga");
        personaService.setEdad(50);
        return personaService.getPersona();
    }
}
