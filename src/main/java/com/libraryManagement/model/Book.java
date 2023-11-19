package com.libraryManagement.model;

import lombok.*;

import java.text.DateFormat;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    private String id;
    private String bookName;
    private int author;
    private int pageNumbers;
    private String topic;
    private LocalDate releaseDate;
    private Boolean available;

    public Book(String bookName, int author, int pageNumbers, String topic, LocalDate releaseDate, Boolean available) {
        this.bookName = bookName;
        this.author = author;
        this.pageNumbers = pageNumbers;
        this.topic = topic;
        this.releaseDate = releaseDate;
        this.available = available;
    }

}
