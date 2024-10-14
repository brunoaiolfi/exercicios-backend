package com.example.atividade8.models;

public record Ano(
        String codigo,
        String nome
) {
    public Ano toEntity() {
        return new Ano(codigo, nome);
    }
}
