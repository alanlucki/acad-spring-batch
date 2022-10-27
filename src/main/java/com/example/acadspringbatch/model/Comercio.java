package com.example.acadspringbatch.model;

public class Comercio {

    private String contrato;
    private String comercio;
    private String validacion;
    
    public Comercio(){
        super();
    }
    public Comercio(String contrato, String comercio, String validacion) {
        super();
        this.contrato = contrato;
        this.comercio = comercio;
        this.validacion = validacion;
    }

    public String getContrato() {
        return contrato;
    }

    public void setContrato(String contrato) {
        this.contrato = contrato;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }
    
    @Override
    public String toString() {
        return "Comercio [contrato=" + contrato + ", comercio=" + comercio + ", validacion=" + validacion + "]";
    }

}
