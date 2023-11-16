package com.libraryManagement.model;

import lombok.*;

import java.text.DateFormat;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    private String id;
    private String bookName;
    private Author author;
    private int pageNumbers;
    private Topic topic;
    private DateFormat realeseDate;
    private Boolean available;
}
