package com.example.atividade8.models;

public record Marca(
        Integer codigo,
        String nome
) {
    public Marca toEntity() {
        return new Marca(codigo, nome);
    }
}
