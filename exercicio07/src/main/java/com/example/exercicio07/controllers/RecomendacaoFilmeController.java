package com.example.exercicio07.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class RecomendacaoFilmeController {
    private static final Map<String, String> recomendacoes = new HashMap<>();

    static {
        // Gênero: ação, ambiente: futurista
        recomendacoes.put("acao_futurista", "Recomendamos o filme 'Blade Runner 2049'.");
        // Gênero: ação, ambiente: medieval
        recomendacoes.put("acao_medieval", "Recomendamos o filme 'Coração Valente'.");
        // Gênero: comédia, ambiente: contemporâneo
        recomendacoes.put("comedia_contemporaneo", "Recomendamos o filme 'Superbad: É Hoje'.");
        // Gênero: comédia, ambiente: futurista
        recomendacoes.put("comedia_futurista", "Recomendamos o filme 'Guardiões da Galáxia'.");
        // Gênero: drama, ambiente: histórico
        recomendacoes.put("drama_historico", "Recomendamos o filme 'A Lista de Schindler'.");
        // Gênero: drama, ambiente: contemporâneo
        recomendacoes.put("drama_contemporaneo", "Recomendamos o filme 'Oito Mulheres e um Segredo'.");
        // Gênero: terror, ambiente: casa mal-assombrada
        recomendacoes.put("terror_casa-mal-assombrada", "Recomendamos o filme 'Invocação do Mal'.");
        // Gênero: terror, ambiente: espaço
        recomendacoes.put("terror_espaco", "Recomendamos o filme 'Alien: O Oitavo Passageiro'.");
        // Gênero: romance, ambiente: contemporâneo
        recomendacoes.put("romance_contemporaneo", "Recomendamos o filme 'La La Land: Cantando Estações'.");
        // Gênero: romance, ambiente: histórico
        recomendacoes.put("romance_historico", "Recomendamos o filme 'Orgulho e Preconceito'.");
    }

    @GetMapping("/recomendar")
    public String recomendar(@RequestParam String genero, @RequestParam String ambiente) {
        // Criar uma chave combinando gênero e ambiente
        String chave = genero.toLowerCase() + "_" + ambiente.toLowerCase();

        // Buscar a recomendação no mapa
        String recomendacao = recomendacoes.get(chave);

        // Caso não encontre uma recomendação, retornar uma mensagem padrão
        if (recomendacao != null) {
            return recomendacao;
        } else {
            return "Desculpe, não temos uma recomendação para esse gênero e ambiente.";
        }
    }
}
