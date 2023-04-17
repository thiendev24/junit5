package com.junit5.model;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Movie {

    private String title;

    private Date releaseDate;

    private String duration;

}