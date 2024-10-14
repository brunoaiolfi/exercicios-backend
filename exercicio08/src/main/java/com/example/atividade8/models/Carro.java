package com.example.atividade8.models;

public record Carro(
        Integer TipoVeiculo,
        String Valor,
        String Marca,
        String Modelo,
        Integer AnoModelo,
        String Combustivel,
        String CodigoFipe,
        String MesReferencia,
        String SiglaCombustivel
) {
    public Carro toEntity() {
        return new Carro(
                TipoVeiculo,
                Valor,
                Marca,
                Modelo,
                AnoModelo,
                Combustivel,
                CodigoFipe,
                MesReferencia,
                SiglaCombustivel
        );
    }
}
