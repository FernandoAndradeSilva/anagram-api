package br.com.wayon.anagram.api.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AnagramService {

    List<String> generateAnagrams(String word);

}
