package edu.bht.ase.redlib.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookDto {
    private String id;
    private String name;
    private String summary;
    private List<AuthorDto> authors;
    private List<ReviewDto> reviews;
    private List<String> tags;
}
