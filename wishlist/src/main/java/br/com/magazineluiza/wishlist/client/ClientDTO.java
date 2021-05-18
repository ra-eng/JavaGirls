package br.com.magazineluiza.wishlist.client;

import br.com.magazineluiza.wishlist.wishlist.Wishlist;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ClientDTO {

    private int id;

    @NotNull @NotEmpty
    private String cpf;
    
    @NotNull @NotEmpty
    private String name;

    @NotNull @NotEmpty @Email
    private String email;

    @NotNull @NotEmpty
    private String password;

    private Wishlist wishlist;

    public ClientDTO(){}

    public ClientDTO(String cpf, String name, String email, String password, Wishlist wishlist) {
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
        this.wishlist = new Wishlist();
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

    public Wishlist getWishlist() {
        return wishlist;
    }

    public void setWishlist(Wishlist wishlist) {
        this.wishlist = wishlist;
    }
}
