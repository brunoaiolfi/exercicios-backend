package com.example.demo.controllers;

import com.example.demo.domain.dto.TransacaoRequestDTO;
import com.example.demo.domain.dto.TransacaoResponseDTO;
import com.example.demo.domain.mapper.ContaMapper;
import com.example.demo.services.TransacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacoesService transacoesService;
    private final ContaMapper contaMapper;

    @Autowired
    public TransacaoController(TransacoesService transacoesService, ContaMapper contaMapper) {
        this.transacoesService = transacoesService;
        this.contaMapper = contaMapper;
    }

    @PostMapping
    public TransacaoResponseDTO gerarTransacao(@RequestBody TransacaoRequestDTO request) {
        return transacoesService.realizarTransacao(request, contaMapper);
    }
}
