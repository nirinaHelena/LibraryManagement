package com.libraryManagement.model;


import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User {
    private String idUser;
    private String UserName;
    private String UserReference;
}
