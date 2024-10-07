package com.web_loja.domain;

import com.web_loja.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagamentoCartao extends Pagamento{

    private Integer numeroParcelas;   

    public PagamentoCartao(){

    }

    public PagamentoCartao(Integer id, Integer numeroParcelas, Pedido pedido, EstadoPagamento estadoPagamento) {
        super(id, pedido, estadoPagamento);
        this.numeroParcelas = numeroParcelas;
    }

    

    public Integer getNumeroParcelas() {
        return numeroParcelas;
    }

    public void setNumeroParcelas(Integer numeroParcelas) {
        this.numeroParcelas = numeroParcelas;
    }





}
