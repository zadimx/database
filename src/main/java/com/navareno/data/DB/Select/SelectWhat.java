package com.navareno.data.DB.Select;


import com.navareno.data.Server.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectWhat {
    private static final String GET_TABLE_WHAT = "SELECT * FROM what";
    private DBWorker worker;

    private int td0;


    public int getTd0() {
        return td0;
    }


    public SelectWhat() throws SQLException {
        worker = new DBWorker();
        try(PreparedStatement statement = worker.getConnection().prepareStatement(GET_TABLE_WHAT);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()){
                td0 = resultSet.getInt("td_0");
            }
            resultSet.close();
            worker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
