package br.com.magazineluiza.wishlist.client;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "client")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private @NotNull String cpf;
    private @NotNull String name;
    private @NotNull String email;
    private @NotNull String password;

    public Client() {
    }

    public Client(String cpf, String name, String email, String password) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
    }

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

    public void addClient(Client client){

    }

}
