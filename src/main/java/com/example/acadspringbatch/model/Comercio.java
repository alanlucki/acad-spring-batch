package com.example.acadspringbatch.model;

public class Comercio {


    private String contrato;
    private String comercio;
    private String estado_contr;
    private String estado_comer;
    private String ind_180_dias;
    private String ind_comerc_deb;
    private String ind_banco_deb;

    public Comercio(){
        super();
    }
    public Comercio(String contrato, String comercio, String estado_contr, String estado_comer, String ind_180_dias, String ind_comerc_deb, String ind_banco_deb) {
        super();
        this.contrato = contrato;
        this.comercio = comercio;
        this.estado_contr = estado_contr;
        this.estado_comer = estado_comer;
        this.ind_180_dias = ind_180_dias;
        this.ind_comerc_deb = ind_comerc_deb;
        this.ind_banco_deb = ind_banco_deb;
    }

    @Override
    public String toString() {
        return "Comercio{" + "contrato=" + contrato + ", comercio=" + comercio + ", estado_contr=" + estado_contr + ", estado_comer=" + estado_comer + ", ind_180_dias=" + ind_180_dias + ", ind_comerc_deb=" + ind_comerc_deb + ", ind_banco_deb=" + ind_banco_deb + '}';
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

    public String getEstado_contr() {
        return estado_contr;
    }

    public void setEstado_contr(String estado_contr) {
        this.estado_contr = estado_contr;
    }

    public String getEstado_comer() {
        return estado_comer;
    }

    public void setEstado_comer(String estado_comer) {
        this.estado_comer = estado_comer;
    }

    public String getInd_180_dias() {
        return ind_180_dias;
    }

    public void setInd_180_dias(String ind_180_dias) {
        this.ind_180_dias = ind_180_dias;
    }

    public String getInd_comerc_deb() {
        return ind_comerc_deb;
    }

    public void setInd_comerc_deb(String ind_comerc_deb) {
        this.ind_comerc_deb = ind_comerc_deb;
    }

    public String getInd_banco_deb() {
        return ind_banco_deb;
    }

    public void setInd_banco_deb(String ind_banco_deb) {
        this.ind_banco_deb = ind_banco_deb;
    }

    
}
