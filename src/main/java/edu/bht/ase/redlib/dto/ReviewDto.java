package edu.bht.ase.redlib.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewDto {
    private String id;
    private String username;
    private String text;
    private Integer rating;
}
