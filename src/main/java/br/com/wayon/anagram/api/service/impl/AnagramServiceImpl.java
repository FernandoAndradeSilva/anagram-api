package br.com.wayon.anagram.api.service.impl;

import br.com.wayon.anagram.api.service.AnagramService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnagramServiceImpl implements AnagramService {

    @Override
    public List<String> generateAnagrams(String word) {

        List<String> anagrams = new ArrayList<>();

        // Adiciona o primeiro caractere da palavra à lista de anagramas
        anagrams.add(String.valueOf(word.charAt(0)));

        // Percorre a palavra a partir do segundo caractere
        for (int i = 1; i < word.length(); i++) {
            // Pega o caractere atual da palavra
            char currentChar = word.charAt(i);
            // Cria uma nova lista para armazenar os novos anagramas
            List<String> newAnagrams = new ArrayList<>();

            // A lógica é sempre ir pegando o caractere atyal (current char) e ir adicionando em todas posições de cada anagrama
            for (String anagram : anagrams) {
                for (int j = 0; j <= anagram.length(); j++) {

                    // Cria um novo anagrama inserindo o caractere atual na posição j de acordo com o tamanho daquele anagrama
                    // (ex se o anagrama tem tamanho  3 em cada anagrama ele vai adicionar o novo caractere em tres posicoes de cada anagrama)
                    String newAnagram = anagram.substring(0, j) + currentChar + anagram.substring(j);

                    // Adiciona o novo anagrama à lista de novos anagramas
                    newAnagrams.add(newAnagram);
                }
            }
            // Atualiza a lista de anagramas com os novos anagramas gerados
            anagrams = newAnagrams;
        }
        return anagrams;

    }
}
