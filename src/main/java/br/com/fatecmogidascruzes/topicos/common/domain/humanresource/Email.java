package br.com.fatecmogidascruzes.topicos.common.domain.humanresource;

import java.util.regex.Pattern;

public class Email {
    private String address;

    public Email(String address) {
        String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        if (!Pattern.matches(regex, address)) {
            throw new IllegalArgumentException("Endereço de e-mail inválido.");
        }
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}





