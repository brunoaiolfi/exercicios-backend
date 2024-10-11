package com.example.atividade8.models;

public record Modelos(
        Modelo[] modelos
) {
    public Modelos toEntity() {
        return new Modelos(modelos);
    }
}
