package com.gft.Biblioteca.dto.leitor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@RestController
public class ViaCepCtrl implements Serializable {

    private static final long serialVersionUID = 6046704732666502085L;

    //funcao para obter o endereco completo via cep. nota: somente ele será armazenado no banco; o endereco sera apenas exibido!!!

    public String doObterCep(@PathVariable(name = "cep") String cep) {

        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://viacep.com.br/ws/{cep}/json/";
        Map<String, String> params = new HashMap<String, String>();
        params.put("cep", cep);


        Endereco enderecoTO = restTemplate.getForObject(uri, Endereco.class, params);

        return enderecoTO.toString();
    }


}
