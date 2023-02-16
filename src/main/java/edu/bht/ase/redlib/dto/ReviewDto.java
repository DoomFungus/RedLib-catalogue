package edu.bht.ase.redlib.dto;

import lombok.Data;

@Data
public class ReviewDto {
    private String id;
    private String name;
    private String text;
    private Integer rating;
}
