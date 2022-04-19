package com.example.BS4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@PropertySource("classpath:miconfiguracion.properties")
@Component
@ConfigurationProperties(prefix = "configuracion")
public class MiConfiguracionProperties {

    private String valor1, valor2;

    public void setValor1(String valor1) {
        this.valor1 = valor1;
    }

    public void setValor2(String valor2) {
        this.valor2 = valor2;
    }

    @Override
    public String toString() {
        return "MiConfiguracionProperties{" +
                "valor1='" + valor1 + '\'' +
                ", valor2='" + valor2 + '\'' +
                '}';
    }
}
