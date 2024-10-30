package com.example.demo.movies.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "movie")
@Table(name = "movie", uniqueConstraints = @UniqueConstraint(name = "movie_name_unique", columnNames = "name"))
public class Movie {

    @Id
    @SequenceGenerator(name = "movie_id_sequence", sequenceName = "movie_id_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "movie_id_sequence")
    @Column(name = "id", updatable = false)
    private long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "release_date", nullable = false, columnDefinition = "DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd") // default html date type input date pattern "yyyy-mm-dd"
    private Date releaseDate;

    // only for users to see
    @Column(name = "rating", nullable = true, columnDefinition = "Decimal(10,2)")
    private Double rating;

    @Column(name = "genre", nullable = false, columnDefinition = "TEXT")
    private String genre;

    @OneToMany(mappedBy = "movie")
    @JsonManagedReference
    private List<Review> reviews;

    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    private String description;

}
