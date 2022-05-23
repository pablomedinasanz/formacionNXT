package com.example.Propiedades1;


import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;

@Component
@org.springframework.boot.context.properties.ConfigurationProperties(prefix = "valores")
public class ConfigurationProperties {

    private String var1;
    private int var2;

    public String getVar1() {
        return var1;
    }

    public void setVar1(String var1) {
        this.var1 = var1;
    }

    public int getVar2() {
        return var2;
    }

    public void setVar2(int var2) {
        this.var2 = var2;
    }
}
