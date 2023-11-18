package com.libraryManagement.repository;

import com.libraryManagement.model.Author;
import com.libraryManagement.model.Subscribers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscribersCrudOperations implements CrudOperations<Subscribers> {
    DatabaseConfig databaseConfig= new DatabaseConfig();
    @Override
    public List<Subscribers> findAll() {
        List<Subscribers> allSubscribers= new ArrayList<>();
        String sql= "select * from subscribers ;";

        try (PreparedStatement preparedStatement= databaseConfig.createConnection().prepareStatement(sql)){
            ResultSet resultSet= preparedStatement.executeQuery();
            while (resultSet.next()){
                String id= String.valueOf(resultSet.getInt("id"));
                String authorName= resultSet.getString("subscriberName");
                String reference= resultSet.getString("subscriberReference");

                Subscribers subscribers= new Subscribers(id, authorName, reference);
                allSubscribers.add(subscribers);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return allSubscribers;
    }

    @Override
    public List<Subscribers> saveAll(List<Subscribers> toSave) {
        return null;
    }

    @Override
    public Subscribers save(Subscribers toSave) {
        return null;
    }

    @Override
    public void delete(Subscribers toDelete) {

    }
}
