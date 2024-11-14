package com.example.demo.domain.mapper;
import com.example.demo.domain.dto.ContaDTO;
import com.example.demo.models.Conta;
import org.springframework.stereotype.Component;

@Component
public class ContaMapper {
    public ContaDTO toDTO(Conta conta) {
        return new ContaDTO(conta.getCodigo(), conta.getCliente());
    }
}