package com.example.atividade8.controllers;

import com.example.atividade8.models.CarroDTO;
import com.example.atividade8.models.FipeResponse;
import com.example.atividade8.services.FipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class FipeController {

    @Autowired
    private FipeService fipeService;

    @PostMapping("/valor")
    public FipeResponse obterValorFipe(@RequestBody CarroDTO carroDTO) {
        return fipeService.buscarValorFipe(carroDTO);
    }
}
