package edu.bht.ase.redlib.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Document("books")
public class Book {
    @Id
    private String id;
    private String name;
    private String summary;
    private List<Author> authors = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
}
