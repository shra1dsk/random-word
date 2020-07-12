package com.example.randomword.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

@Service
public class DictionaryService {

    private List<String> dictionary;

    private Random random = new Random();

    public String getRandomWord() {
        return this.dictionary.get(random.nextInt(dictionary.size()));
    }

    @Autowired
    public DictionaryService(@Value("${dictionary.file}") String dictionaryFile) throws IOException {
        File file = new ClassPathResource(dictionaryFile).getFile();
        Path path = Paths.get(file.getPath());
        this.dictionary = Files.readAllLines(path);
    }

}
