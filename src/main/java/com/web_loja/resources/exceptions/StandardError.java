package com.web_loja.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {

    private Integer status;
    private String mensagem;
    private Long timeStamp;

    public StandardError(Integer status, String mensagem, Long timeStamp) {
        this.mensagem = mensagem;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

    

}
