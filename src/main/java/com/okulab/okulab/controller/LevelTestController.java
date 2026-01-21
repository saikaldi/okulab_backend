package com.okulab.okulab.controller;

import com.okulab.okulab.models.LevelTest;
import com.okulab.okulab.repository.LevelTestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/api/level-test")

@CrossOrigin(origins = "http://127.0.0.1:5500")
public class LevelTestController {

    private final LevelTestRepository levelTestRepository;

    public LevelTestController(LevelTestRepository levelTestRepository) {
        this.levelTestRepository = levelTestRepository;
    }

    @GetMapping("/questions")
    public List<LevelTest> getAllQuestions() {

        // We recieve all the questions from DB
        return levelTestRepository.findAll();
    }

}
