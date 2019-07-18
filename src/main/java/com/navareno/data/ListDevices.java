package com.navareno.data;

import com.navareno.data.Server.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ListDevices {


    private static final String SELECT_NEW = "SELECT Device FROM devices";

    private static ArrayList<String> arrayListDevices;
    private DBWorker worker;

    public ListDevices() throws SQLException {
        worker = new DBWorker();
        arrayListDevices = new ArrayList<>();
        try (PreparedStatement statement = worker.getConnection().prepareStatement(SELECT_NEW)){

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
            {
                arrayListDevices.add(resultSet.getString(1));
            }
            resultSet.close();
            worker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
