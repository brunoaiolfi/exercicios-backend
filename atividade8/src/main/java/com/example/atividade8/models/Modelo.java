package com.example.atividade8.models;

public record Modelo(
        Integer codigo,
        String nome
) {
    public Modelo toEntity() {
        return new Modelo(codigo, nome);
    }
}

