package br.com.wayon.anagram.api.controller;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/anagram")
public class AnagramController {

    private static final Log LOGGER = LogFactory.getLog(AnagramController.class);

    @GetMapping
    public ResponseEntity<?> getWords() {
        return null;
    }

}
