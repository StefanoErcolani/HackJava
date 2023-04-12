package id.aulab.springjpa2.model;

import java.math.BigInteger;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "clients")
public class Clients {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    @Column(name = "client_name", length = 24)
    private String clientName;

    @Column(name = "client_bank_account", length = 64)
    private String clientBankAccount;

    @Column(name = "client_cuenta")
    private Integer clientCuenta;

    @ManyToMany(mappedBy = "client")
    private List<Menu> menu;

    public Clients() {}

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getClientBankAccount() {
        return clientBankAccount;
    }

    public void setClientBankAccount(String clientBankAccount) {
        this.clientBankAccount = clientBankAccount;
    }

    public Integer getClientCuenta() {
        return clientCuenta;
    }

    public void setClientCuenta(Integer clientCuenta) {
        this.clientCuenta = clientCuenta;
    }

    public List<Menu> getMenu() {
        return menu;
    }

    public void setMenu(List<Menu> menu) {
        this.menu = menu;
    }

    
}
