package br.com.wayon.anagram.api.validaton;

import br.com.wayon.anagram.api.dto.palavra.PalavraRequest;

public interface PalavraRequestValidator {
    void validateWord(PalavraRequest request);
}