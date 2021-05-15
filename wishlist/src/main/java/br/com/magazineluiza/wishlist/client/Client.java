package br.com.magazineluiza.wishlist.client;


import br.com.magazineluiza.wishlist.wishlist.Wishlist;

import javax.persistence.*;

@Entity
@Table(name = "client")
public class Client {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "wishlist_id", referencedColumnName = "id")
    private Wishlist wishlist;

    @Column(unique = true)
    private String cpf;
    private String name;
    private String email;
    private String password;

    public Client() {
    }

    public Client(ClientDTO clientDTO) {
        this.cpf = clientDTO.getCpf();
        this.name = clientDTO.getName();
        this.email = clientDTO.getEmail();
        this.password = clientDTO.getPassword();
        this.wishlist = new Wishlist();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
