package br.com.wayon.anagram;

import br.com.wayon.anagram.api.Application;
import br.com.wayon.anagram.api.controller.AnagramController;
import br.com.wayon.anagram.api.dto.palavra.PalavraRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Usei a abordagem de teste com o contexto do Spring para validar os services com dados reais de requisiçoes
// Poderia ter também utilizado teste com Mockito e Mocks de dados.

@SpringBootTest(classes = Application.class)
class AnagramControllerIntegrationTest {

    @Autowired
    private AnagramController anagramController;

    @Test
    void testRequestAnagrams_ValidRequest() {
        PalavraRequest request = new PalavraRequest("abc");
        List<String> expectedAnagrams = Arrays.asList("cba", "bca", "bac", "cab", "acb", "abc");

        ResponseEntity<?> response = anagramController.requestAnagrams(request);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedAnagrams, response.getBody());
    }

    @Test
    void testRequestAnagrams_InvalidRequestOneCaracter() {
        PalavraRequest request = new PalavraRequest("a");

        ResponseEntity<?> response = anagramController.requestAnagrams(request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Descrição não pode ter somente uma letra.", response.getBody());
    }


    @Test
    void testRequestAnagrams_EmptyAnagrams() {
        PalavraRequest request = new PalavraRequest("");

        ResponseEntity<?> response = anagramController.requestAnagrams(request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Descrição não pode ser nula ou vazia.", response.getBody());
    }

    @Test
    void testRequestAnagrams_NullAnagrams() {
        PalavraRequest request = new PalavraRequest(null);

        ResponseEntity<?> response = anagramController.requestAnagrams(request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Descrição não pode ser nula ou vazia.", response.getBody());
    }


    @Test
    void testRequestAnagrams_SpecialCaracteres() {
        PalavraRequest request = new PalavraRequest("@234");

        ResponseEntity<?> response = anagramController.requestAnagrams(request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Descrição deve conter apenas letras.", response.getBody());
    }

    @Test
    void testRequestAnagrams_EmptySpaces() {
        PalavraRequest request = new PalavraRequest("Palavra com");

        ResponseEntity<?> response = anagramController.requestAnagrams(request);

        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Descrição deve conter apenas letras.", response.getBody());
    }

}