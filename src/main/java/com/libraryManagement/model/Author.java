package com.libraryManagement.model;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Author {
    private String id;
    private String authorName;
    private Character sex;

    public Author( String authorName, Character sex) {
        this.authorName = authorName;
        this.sex = sex;
    }
}
