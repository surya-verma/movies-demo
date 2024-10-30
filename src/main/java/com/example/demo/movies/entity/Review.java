package com.example.demo.movies.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "review")
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "movie_rating", nullable = false)
    private Integer movieRating;

    @Column(name = "date_time", nullable = false)
    private Long dateTimeMilli;

    @Column(name = "submitter_name", nullable = false)
    private String submitterName;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    @JsonBackReference
    private Movie movie;

}