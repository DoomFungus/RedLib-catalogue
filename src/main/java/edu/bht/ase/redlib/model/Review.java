package edu.bht.ase.redlib.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@Document("reviews")
public class Review {
    @Id
    private String id;
    private String username;
    private String text;
    private Integer rating;
    private String bookId;
}
