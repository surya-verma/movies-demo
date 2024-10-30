package com.example.demo.movies.dto;

import lombok.Data;

@Data
public class ReviewRequest {

    private String content;
    private Integer movieRating;
    private String submitterName;
}
