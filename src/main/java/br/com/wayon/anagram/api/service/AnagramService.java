package br.com.wayon.anagram.api.service;

import org.springframework.stereotype.Service;

@Service
public interface AnagramService {

    void generateWords(String word);

}
