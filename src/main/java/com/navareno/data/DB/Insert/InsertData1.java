package com.navareno.data.DB.Insert;

import com.navareno.data.Server.DBWorker;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertData1 extends DBWorker {
    private long time;
    private static final String INSERTDATA_1 = "INSERT INTO mydbtest.data1 (axis1, axis2, axis3, axis4, longitude, latitude, time) " +
            "values (?,?,?,?,?,?,?)";
    private DBWorker worker1;

    public InsertData1(Integer weight1, Integer weight2,
                       Integer weight3, Integer weight4, String lngd, String latd) throws SQLException {
        worker1 = new DBWorker();
        try(PreparedStatement statement = worker1.getConnection().prepareStatement(INSERTDATA_1)) {
            time = new Date().getTime();
//            SimpleDateFormat time = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
            statement.setInt(1,weight1);
            statement.setInt(2,weight2);
            statement.setInt(3,weight3);
            statement.setInt(4,weight4);
            statement.setString(5,lngd);
            statement.setString(6,latd);
            statement.setLong(7, time);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if (weight1!=null) {
                this.worker1.getConnection().close();
            }
        }
    }
}
