package com.example.atividade8.models;

public record CarroDTO(
        String marca,
        String modelo,
        String ano
) {
    public CarroDTO toEntity() {
        return new CarroDTO(marca, modelo, ano);
    }
}
