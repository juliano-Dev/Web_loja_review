package com.web_loja.domain;

import java.util.Date;

import com.web_loja.domain.enums.EstadoPagamento;

import jakarta.persistence.Entity;

@Entity
public class PagamentoBoleto extends Pagamento{

    private Date dataVencimento;
    private Date dataPagamento;

    public PagamentoBoleto(){

    }

    public PagamentoBoleto(Integer id, Date dataPagamento, Date dataVencimento, Pedido pedido, EstadoPagamento estadoPagamento) {
        super(id, pedido, estadoPagamento);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }
    
    

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    

}
