package com.web_loja.domain;

import java.io.Serializable;
import java.util.Objects;

import com.web_loja.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)//define como as subclasse serao mapeadas no banco
public abstract class Pagamento implements Serializable{

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name="pedido_id")
    @MapsId
    private Pedido pedido;

    private Integer estadoPagamento;

    public Pagamento() {
    }

    public Pagamento(Integer id, Pedido pedido, EstadoPagamento estadoPagamento) {
        this.id = id;
        this.pedido = pedido;
        this.estadoPagamento = estadoPagamento.getCodigo();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public EstadoPagamento getEstadoPagamento() {
        return EstadoPagamento.toEnum(estadoPagamento);
    }

    public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
        this.estadoPagamento = estadoPagamento.getCodigo();
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
        final Pagamento other = (Pagamento) obj;
        return Objects.equals(this.id, other.id);
    }

    





}
