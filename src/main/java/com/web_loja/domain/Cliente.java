package com.web_loja.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.web_loja.domain.enums.TipoCliente;

import jakarta.annotation.Nonnull;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Nonnull
    private String nome;
    
    @Nonnull
    private String email;
    
    @Nonnull
    private String cpfOuCnpj;
    
    private Integer tipo;

    @JsonManagedReference
    @OneToMany(mappedBy="cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    //definido Set (conjunto) para garantir a nao repeticao de numeros na classe cliente
    //e tambem devido a simplicidade da classe (apenas um atributo)

    @ElementCollection
    @CollectionTable(name="TELEFONE")
    private Set<String> telefones = new HashSet<>();

    public Cliente() {
    }

    public Cliente(Integer id, String email, String cpfOuCnpj, String nome, TipoCliente tipo) {
        this.cpfOuCnpj = cpfOuCnpj;
        this.email = email;
        this.id = id;
        this.nome = nome;
        this.tipo = tipo.getCodigo();
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return TipoCliente.toEnum(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getCodigo();
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    /*
    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
     */

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }



    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        return Objects.equals(this.id, other.id);
    }






}
