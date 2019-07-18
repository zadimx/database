package com.navareno.data.DB.Update;


import com.navareno.data.Server.DBWorker;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateData1 extends DBWorker {
    private static final String UPDATE_1 = "UPDATE mydbtest.data1 SET axis1=?,axis2=?, axis3=?, axis4=?, longitude=?, latitude=? WHERE id=1";
    private DBWorker worker1;

    public UpdateData1(Integer weight1, Integer weight2,
                       Integer weight3, Integer weight4, String lngd, String latd) throws SQLException {
        worker1 = new DBWorker();
        try(PreparedStatement statement = worker1.getConnection().prepareStatement(UPDATE_1)) {
//            ConnectionWorker.string1 = String.valueOf(weight);
            statement.setInt(1,weight1);
            statement.setInt(2,weight2);
            statement.setInt(3,weight3);
            statement.setInt(4,weight4);
            statement.setString(5,lngd);
            statement.setString(6,latd);
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