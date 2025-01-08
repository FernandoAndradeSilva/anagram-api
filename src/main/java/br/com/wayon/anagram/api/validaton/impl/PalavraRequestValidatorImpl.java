package br.com.wayon.anagram.api.validaton.impl;

import br.com.wayon.anagram.api.dto.palavra.PalavraRequest;
import br.com.wayon.anagram.api.exception.ValidacaoAnagramaException;
import br.com.wayon.anagram.api.validaton.PalavraRequestValidator;
import org.springframework.stereotype.Component;

/*
* Há várias forma de fazer a validação, mas como é uma validação
* específica e vai validar dados mais detalhados acredito que faça
* sentido uma validação feita dessa forma.
*
* Isso promove a separação de responsabilidades e
* facilita a manutenção e testes do código.
* Além disso, permite que você altere ou expanda a lógica de
* validação sem modificar o controlador ou outras partes do sistema.
*
* */


@Component
public class PalavraRequestValidatorImpl implements PalavraRequestValidator {

    @Override
    public void validateWord(PalavraRequest request) {

        // Validação de nulo ou vazio
        if(request.descricao() == null || request.descricao().isEmpty()) {
            throw new ValidacaoAnagramaException("Descrição não pode ser nula ou vazia.");
        }

        // Validação de tamanho 1
        if(request.descricao().length() == 1) {
            throw new ValidacaoAnagramaException("Descrição não pode ter somente uma letra.");
        }

        // Validação de caracteres especiais
        // Valida também espacos em branco
        if (!request.descricao().matches("[a-zA-Z]+")) {
            throw new ValidacaoAnagramaException("Descrição deve conter apenas letras.");
        }




    }
}