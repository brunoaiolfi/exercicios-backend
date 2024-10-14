package com.example.atividade8.services;

import com.example.atividade8.models.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FipeService {

    public ResponseEntity<FipeResponse> buscarValorFipe(CarroDTO dto) {
        RestTemplate restTemplate = new RestTemplate();

        Marca marca = this.buscarMarca(dto.marca());
        Modelo modelo = this.buscarModelo(marca.codigo(), dto.modelo());
        Ano ano = this.buscarAno(marca.codigo(), modelo.codigo(), dto.ano());

        String url = UriComponentsBuilder.fromHttpUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/")
                .path(marca.codigo().toString())
                .path("/modelos/")
                .path(modelo.codigo().toString())
                .path("/anos/")
                .path(ano.codigo())
                .toUriString();

        Carro carro = restTemplate.getForObject(url, Carro.class);

        FipeResponse response = new FipeResponse(carro.Valor(), carro.MesReferencia());
        return ResponseEntity.ok(response);
    }

    public Marca buscarMarca(String marca) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromHttpUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/")
                .toUriString();

        Marca[] marcasArray = restTemplate.getForObject(url, Marca[].class);

        List<Marca> marcas = Arrays.asList(marcasArray);

        Optional<Marca> marcaEncontrada = marcas.stream()
                .filter(m -> m.nome().contains(marca))
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

    public Ano buscarAno(Integer marca, Integer modelo, String ano) {
        RestTemplate restTemplate = new RestTemplate();

        String url = UriComponentsBuilder
                .fromHttpUrl("https://parallelum.com.br/fipe/api/v1/carros/marcas/")
                .path(marca.toString())
                .path("/modelos/")
                .path(modelo.toString())
                .path("/anos")
                .toUriString();

        Ano[] anosArray = restTemplate.getForObject(url, Ano[].class);

        List<Ano> anos = Arrays.asList(anosArray);

        Optional<Ano> anoEncontrado = anos.stream()
                .filter(a -> a.nome().contains(ano))
                .findFirst();

        return anoEncontrado.orElse(null);
    }

}


