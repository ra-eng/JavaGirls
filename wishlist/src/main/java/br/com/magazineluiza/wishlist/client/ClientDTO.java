package br.com.magazineluiza.wishlist.client;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class ClientDTO {

    private int id;

    @NotNull
    private String cpf;

    @NotNull
    private String name;

    @NotNull @Email
    private String email;

    @NotNull
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
