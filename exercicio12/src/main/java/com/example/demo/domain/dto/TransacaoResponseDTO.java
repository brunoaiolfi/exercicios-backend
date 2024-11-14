package com.example.demo.domain.dto;

public record TransacaoResponseDTO(ContaDTO origem, ContaDTO destino, Double valor) {}
