package com.example.BS4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "parametros")
public class Properties {

    private String url, password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Properties{" +
                "url='" + url + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
