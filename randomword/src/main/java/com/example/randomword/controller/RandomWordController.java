package com.example.randomword.controller;


import com.example.randomword.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/dictionary")
public class RandomWordController {

    @Autowired
    DictionaryService dictionaryService;

    @GetMapping("/randomWord")
    public String getRandomWord(){
        return dictionaryService.getRandomWord();
    }
}
