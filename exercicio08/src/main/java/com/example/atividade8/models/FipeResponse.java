package com.example.atividade8.models;

public record FipeResponse (
        String valor,
        String mesReferencia
) {
    public FipeResponse(String valor, String mesReferencia) {
        this.valor = valor;
        this.mesReferencia = mesReferencia;
    }
}