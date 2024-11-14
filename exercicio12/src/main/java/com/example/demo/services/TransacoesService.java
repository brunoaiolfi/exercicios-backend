package com.example.demo.services;

import com.example.demo.domain.dto.TransacaoRequestDTO;
import com.example.demo.domain.dto.TransacaoResponseDTO;
import com.example.demo.domain.mapper.ContaMapper;
import com.example.demo.models.Conta;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransacoesService {
    private final List<Conta> contas = new ArrayList<>();

    public TransacoesService() {
        contas.add(new Conta("500-1", "Fulano", 1000.0));
        contas.add(new Conta("320-2", "Ciclano", 500.0));
    }

    public Conta findContaByCodigo(String codigo) {
        return contas.stream()
                .filter(conta -> conta.getCodigo().equals(codigo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Conta não encontrada"));
    }

    public TransacaoResponseDTO realizarTransacao(TransacaoRequestDTO request, ContaMapper mapper) {
        Conta origem = findContaByCodigo(request.origem());
        Conta destino = findContaByCodigo(request.destino());

        if (origem.getSaldo() < request.valor()) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        origem.setSaldo(origem.getSaldo() - request.valor());
        destino.setSaldo(destino.getSaldo() + request.valor());

        return new TransacaoResponseDTO(mapper.toDTO(origem), mapper.toDTO(destino), request.valor());
    }
}