package edu.bht.ase.redlib.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document("reviews")
public class Review {
    @Id
    private Integer id;
    private String name;
    private String text;
    private Integer rating;
    @DBRef
    private Book book;
}
