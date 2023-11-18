package com.libraryManagement.repository;

import com.libraryManagement.model.Author;
import com.libraryManagement.model.Subscribers;

import java.sql.Connection;
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
        List<Subscribers> savedSubscribers= new ArrayList<>();
        for (Subscribers subscribers: toSave){
            save(subscribers);
            savedSubscribers.add(subscribers);
        }
        return savedSubscribers;
    }

    @Override
    public Subscribers save(Subscribers toSave) {
        String sql= "insert into subscribers (subscriberName, subscriberReference)" +
                "values (?, ?) ;";

        try (Connection connection= databaseConfig.createConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1, toSave.getUserName());
            preparedStatement.setString(2, toSave.getUserReference());

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return toSave;
    }

    @Override
    public void delete(Subscribers toDelete) {
        String sql= "delete from subscribers where id= ? ;";

        try (Connection connection= databaseConfig.createConnection();
             PreparedStatement preparedStatement= connection.prepareStatement(sql)
        ){
            preparedStatement.setInt(1, Integer.parseInt(toDelete.getIdUser()));
            preparedStatement.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
