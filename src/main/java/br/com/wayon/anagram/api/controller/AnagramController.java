package br.com.wayon.anagram.api.controller;


import br.com.wayon.anagram.api.dto.palavra.PalavraRequest;
import br.com.wayon.anagram.api.exception.ValidacaoAnagramaException;
import br.com.wayon.anagram.api.service.AnagramService;
import br.com.wayon.anagram.api.validaton.PalavraRequestValidator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
* Boas práticas de logs são essenciais para o conceito de
* observabilidade em sistemas de software
 */


@RestController
@RequestMapping("/anagram")
public class AnagramController {

    private static final Log LOGGER = LogFactory.getLog(AnagramController.class);

    @Autowired
    private AnagramService anagramService;

    @Autowired
    private PalavraRequestValidator validator;


    @PostMapping
    public ResponseEntity<?> requestAnagrams(@RequestBody PalavraRequest request) {



        LOGGER.info("Entering requestAnagrams with request: " + request.descricao());

        // Validação da escrita da palava
        try {
            validator.validateWord(request);
        } catch (ValidacaoAnagramaException e) {
            LOGGER.error("Error validating request: " + request.descricao(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }

        LOGGER.info("Starting creating anagra,s: " + request.descricao());

        // Validação da execução dos anagramas
        try {
            List<String> anagramas = anagramService.generateAnagrams(request.descricao());
            LOGGER.info("Exiting requestAnagrams");
            return anagramas.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(anagramas);

        } catch (Exception e) {
            LOGGER.error("Error creating anagrams: " + request.descricao(), e);
            return ResponseEntity.badRequest().body(e.getMessage());
        }





    }

}
