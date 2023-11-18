package com.libraryManagement.repository;

import com.libraryManagement.model.Author;
import com.libraryManagement.model.Book;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author> {
    DatabaseConfig databaseConfig= new DatabaseConfig();
    @Override
    public List<Author> findAll() {
        List<Author> allAuthor= new ArrayList<>();
        String sql= "select * from author ;";

        try (PreparedStatement preparedStatement= databaseConfig.createConnection().prepareStatement(sql)){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String id= String.valueOf(resultSet.getInt("id"));
                String authorName= resultSet.getString("authorName");
                Character sex= resultSet.getString("sex").charAt(0);

                Author author= new Author(id, authorName, sex);
                allAuthor.add(author);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allAuthor;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        List<Author> savedAuthor= new ArrayList<>();
        for (Author author: toSave){
            save(author);
            savedAuthor.add(author);
        }
        return savedAuthor;
    }

    @Override
    public Author save(Author toSave) {
        String sql= "insert into author (authorName, sex)" +
                "values (?, ?) ;";

        try (Connection connection= databaseConfig.createConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1, toSave.getAuthorName());
            preparedStatement.setString(2, String.valueOf(toSave.getSex()));

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public void delete(Author toDelete) {
        String sql= "delete from author where id= ? ;";

        try (Connection connection= databaseConfig.createConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(sql)
        ){
            preparedStatement.setInt(1, Integer.parseInt(toDelete.getId()));
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
