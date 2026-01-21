package com.okulab.okulab.config;

import com.okulab.okulab.models.LevelTest;
import com.okulab.okulab.repository.LevelTestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final LevelTestRepository repository;

    public DataLoader(LevelTestRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (repository.count() == 0) {
            LevelTest q1 = new LevelTest();
            q1.setTitle("Choose the correct form: 'She ___ to the gym every day.'");
            q1.setOptions(List.of("go", "goes", "going", "gone"));
            q1.setCorrect(1);
            q1.setLevel("A1");

            LevelTest q2 = new LevelTest();
            q2.setTitle("I have been living in this city ___ five years.");
            q2.setOptions(List.of("since", "for", "at", "during"));
            q2.setCorrect(1);
            q2.setLevel("A2");

            repository.saveAll(List.of(q1, q2));
            System.out.println("--- OKULAB: Test questions loaded to database! ---");
        }
    }
}