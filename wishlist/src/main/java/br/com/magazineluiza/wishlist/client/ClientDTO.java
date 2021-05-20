package br.com.magazineluiza.wishlist.client;

import br.com.magazineluiza.wishlist.product.Product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@ApiModel(description = "Details about the client")
public class ClientDTO {
    @ApiModelProperty(notes= "The unique id  of the client", required = false, hidden = true)
    private int id;

    @ApiModelProperty(notes= "The client´s CPF", example= "100.111.122-22")
    @NotBlank(message = "{value.not.blank}")
    private String cpf;

    @ApiModelProperty(notes= "The client´s name", example= "Darth Vader")
    @NotBlank(message = "{value.not.blank}")
    private String name;

    @ApiModelProperty(notes= "The client´s email", example= "OEscolhido@Imperio.com")
    @Email(message = "{email.not.null}")
    private String email;

    @ApiModelProperty(notes= "The client´s password", example= "OLadoNegroDaForça")
    @NotBlank(message = "{value.not.blank}")
    private String password;

    @ApiModelProperty(required = false, hidden = true)
    private List<Product> products = new ArrayList<>();

    public ClientDTO(){}

    public ClientDTO(int id, String cpf, String name, String email, String password, List<Product> products) {
        this.id = id;
        this.cpf = cpf;
        this.name = name;
        this.email = email;
        this.password = password;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
