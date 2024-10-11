package com.example.atividade8.services;

import com.example.atividade8.models.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FipeService {

    public FipeResponse buscarValorFipe(CarroDTO dto) {
        RestTemplate restTemplate = new RestTemplate();

        Marca marca = this.buscarMarca(dto.marca());
        Modelo modelo = this.buscarModelo(marca.codigo(), dto.modelo());

        System.out.println("PUTA QUE PARIU");

        String url = UriComponentsBuilder.fromHttpUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/")
                .path(marca.codigo().toString())
                .path("/modelos/")
                .path(modelo.codigo().toString())
                .path("/anos/")
                .path(String.valueOf(dto.ano()))
                .toUriString();

        FipeResponse response = restTemplate.getForObject(url, FipeResponse.class);

        return response;
    }

    public Marca buscarMarca(String marca) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromHttpUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/")
                .toUriString();

        Marca[] marcasArray = restTemplate.getForObject(url, Marca[].class);

        List<Marca> marcas = Arrays.asList(marcasArray);

        Optional<Marca> marcaEncontrada = marcas.stream()
                .filter(m -> m.nome().equalsIgnoreCase(marca))
                .findFirst();

        return marcaEncontrada.orElse(null);
    }

    public Modelo buscarModelo(Integer marca, String modelo) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromHttpUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/")
                .path(marca.toString())
                .path("/modelos")
                .toUriString();

        Modelos modelos = restTemplate.getForObject(url, Modelos.class);

        Optional<Modelo> modeloEncontrado = Arrays.stream(modelos.modelos())
                .filter(m -> m.nome().contains(modelo))
                .findFirst();

        return modeloEncontrado.orElse(null);
    }


}


