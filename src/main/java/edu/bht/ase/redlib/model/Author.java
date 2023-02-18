package edu.bht.ase.redlib.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("authors")
public class Author {
    @Id
    private String id;
    private String name;
}
