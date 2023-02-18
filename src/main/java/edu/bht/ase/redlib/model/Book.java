package edu.bht.ase.redlib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("books")
public class Book {
    @Id
    private String id;
    private String name;
    private String summary;
    private List<Author> authors = new ArrayList<>();
    private List<String> tags = new ArrayList<>();
}
