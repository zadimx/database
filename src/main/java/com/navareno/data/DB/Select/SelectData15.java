package com.navareno.data.DB.Select;


import com.navareno.data.Server.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectData15 {
    private static final String GET_TABLE_DATA_1 = "SELECT * FROM data15";
    private DBWorker worker;

    private int axis1;
    private int axis2;
    private int axis3;
    private int axis4;
    private String longitude;
    private String latitude;

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }



    public int getAxis1() {
        return axis1;
    }

    public int getAxis2() {
        return axis2;
    }

    public int getAxis3() {
        return axis3;
    }

    public int getAxis4() {
        return axis4;
    }

    public SelectData15() throws SQLException {
        worker = new DBWorker();
        try(PreparedStatement statement = worker.getConnection().prepareStatement(GET_TABLE_DATA_1);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()){
                axis1 = resultSet.getInt("axis1");
                axis2 = resultSet.getInt("axis2");
                axis3 = resultSet.getInt("axis3");
                axis4 = resultSet.getInt("axis4");
                longitude = resultSet.getString("longitude");
                latitude = resultSet.getString("latitude");

            }
            resultSet.close();
            worker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
