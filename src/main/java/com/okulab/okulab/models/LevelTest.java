package com.okulab.okulab.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data // getter, setter, toString, hashCode, equals — all in one annotation!
@NoArgsConstructor // Empty constructor (for Hibernate)
@AllArgsConstructor // Constructore with all fields
@Table(name = "level_tests")
public class LevelTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Optimlal for MySQL
    private Long id;

    private String title;

    @ElementCollection
    @CollectionTable(name = "test_options", joinColumns = @JoinColumn(name = "test_id"))
    @Column(name = "option_text")
    private List<String> options;

    private int correct;
    private String level;
}