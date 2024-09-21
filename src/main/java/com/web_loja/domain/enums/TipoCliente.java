package com.web_loja.domain.enums;

public enum TipoCliente {

    PESSOA_FISICA(1, "Pessoa Física"),
    PESSOA_JURIDICA (2, "Pessoa Jurídica");

    private Integer codigo;
    private String descricao;

    private TipoCliente(Integer codigo, String descricao){
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
    public static TipoCliente toEnum(Integer codigo){
        if(codigo == null) return null;
        for(TipoCliente tipo : TipoCliente.values()){
            if(codigo.equals(tipo.getCodigo())) return tipo;
        }
        
        throw new IllegalArgumentException("Código inválido: " + codigo);
    }


}
