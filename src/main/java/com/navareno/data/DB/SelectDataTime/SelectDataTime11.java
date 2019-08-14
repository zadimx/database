package com.navareno.data.DB.SelectDataTime;

import com.navareno.data.Server.DBWorker;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class SelectDataTime11 {
    private DBWorker worker;

    private HashMap<String, ArrayList<String>> arrayHistoryValues = new HashMap<>();
    private ArrayList<String> arrayValuesAxis1 = new ArrayList<>();
    private ArrayList<String> arrayValuesAxis2 = new ArrayList<>();
    private ArrayList<String> arrayValuesAxis3 = new ArrayList<>();
    private ArrayList<String> arrayValuesAxis4 = new ArrayList<>();
    private ArrayList<String> arrayValuesLongit = new ArrayList<>();
    private ArrayList<String> arrayValuesLatit = new ArrayList<>();
    private ArrayList<String> arrayValuesTime = new ArrayList<>();

    private long timeFirstDate = new Date().getTime();
    private int axis1;
    private int axis2;
    private int axis3;
    private int axis4;
    private String longitude;
    private String latitude;
    private long time;

    public HashMap<String,ArrayList<String>> arrayHistoryValues() {
        return arrayHistoryValues;
    }

    public SelectDataTime11() throws SQLException {
        worker = new DBWorker();
//        System.out.println(timeFirstDate-3600000+"****"+timeFirstDate);

        try (PreparedStatement statement = worker.getConnection().
                prepareStatement("SELECT * FROM mydbtest.data11 where mydbtest.data11.time");
             ResultSet resultSet = statement.executeQuery()) {
            for (int i=0; resultSet.next(); i++) {
                arrayValuesAxis1.add(String.valueOf(resultSet.getInt("axis1")));
                arrayValuesAxis2.add(String.valueOf(resultSet.getInt("axis2")));
                arrayValuesAxis3.add(String.valueOf(resultSet.getInt("axis2")));
                arrayValuesAxis4.add(String.valueOf(resultSet.getInt("axis4")));
                arrayValuesLongit.add(resultSet.getString("longitude"));
                arrayValuesLatit.add(resultSet.getString("latitude"));
                arrayValuesTime.add(String.valueOf(resultSet.getLong("time")));
//                    System.out.println(axis1+"-----"+voltahe);
            }
            arrayHistoryValues.put("axis1",arrayValuesAxis1);
            arrayHistoryValues.put("axis2",arrayValuesAxis2);
            arrayHistoryValues.put("axis3",arrayValuesAxis3);
            arrayHistoryValues.put("axis4",arrayValuesAxis4);
            arrayHistoryValues.put("longitude",arrayValuesLongit);
            arrayHistoryValues.put("latitude",arrayValuesLatit);
            arrayHistoryValues.put("time",arrayValuesTime);
            resultSet.close();
//            worker.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        for (int x: arrayHourVolt
//        ) {
//            System.out.println(x);
//        }
        worker.getConnection().close();
    }
}