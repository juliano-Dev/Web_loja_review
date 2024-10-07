package com.web_loja.domain.enums;

public enum EstadoPagamento {

    PENDENTE(1, "PENDENTE"),
    QUITADO(2, "QUITADO"),
    CANCELADO(3, "CANCELADO");

    private Integer codigo;
    private String descricao;

    private EstadoPagamento(Integer codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }


    //para poder executar a busca sem instanciar o objeto na classe solicitante
    public static EstadoPagamento toEnum(Integer codigo){
        if(codigo == null) return null;
        for(EstadoPagamento tipo : EstadoPagamento.values()){
            if(codigo.equals(tipo.getCodigo())) return tipo;
        }
        
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }


}
