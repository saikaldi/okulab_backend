package com.okulab.okulab.controller;

import com.okulab.okulab.models.ResultLevelTest;
import com.okulab.okulab.repository.ResultLevelTestRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/results")
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class ResultLevelTestController {

    private final ResultLevelTestRepository repository;

    public ResultLevelTestController(ResultLevelTestRepository repository){
        this.repository=repository;
    }

    @PostMapping("/save")
    public ResultLevelTest saveResult(@RequestBody ResultLevelTest result){
        result.setCompletedAt(LocalDateTime.now());
        return repository.save(result);


    }
}
