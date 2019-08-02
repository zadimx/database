package com.navareno.data.AccessServer.Select;

import com.navareno.data.DB.Select.*;
import com.navareno.data.DB.Update.UpdateData1;

import java.io.*;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class SelectAccount1 {
    /* сокет, через который происходит обмен данными с клиентом*/
    private Socket clientSocket;
    private String string;

    private String[] pass;

    private HashMap<String, String[]> mapTableAndAxis;
    private String[] arrayAxisT1;
    private String[] arrayAxisT2;
    private String[] arrayAxisT3;
    private String[] arrayAxisT4;
    private String[] arrayAxisT5;
    private String[] arrayAxisT6;
    private String[] arrayAxisT7;
    private String[] arrayAxisT8;
    private String[] arrayAxisT9;
    private String[] arrayAxisT10;
    private String[] arrayAxisT11;
    private String[] arrayAxisT12;
    private String[] arrayAxisT13;
    private String[] arrayAxisT14;
    private String[] arrayAxisT15;
    private String[] arrayAxisT16;
    private String[] arrayAxisT17;
    private String[] arrayAxisT18;
    private String[] arrayAxisT19;
    private String[] arrayAxisT20;

    public SelectAccount1(Socket clientSocket, String string, String[] pass, HashMap<String, String[]> mapTableAndAxis,
                          String[] arrayAxisT1, String[] arrayAxisT2, String[] arrayAxisT3, String[] arrayAxisT4, String[] arrayAxisT5, String[] arrayAxisT6, String[] arrayAxisT7, String[] arrayAxisT8, String[] arrayAxisT9, String[] arrayAxisT10,
                          String[] arrayAxisT11, String[] arrayAxisT12, String[] arrayAxisT13, String[] arrayAxisT14, String[] arrayAxisT15, String[] arrayAxisT16, String[] arrayAxisT17, String[] arrayAxisT18, String[] arrayAxisT19, String[] arrayAxisT20) {
        if (string.equals(pass[0]+"db")) {
            System.out.println("Отправка данных на телефон");
            try {
                SelectData1 selectData1 = null;
                SelectData2 selectData2 = null;
                SelectData3 selectData3 = null;
                SelectData4 selectData4 = null;
                SelectData5 selectData5 = null;
                SelectData6 selectData6 = null;
                SelectData7 selectData7 = null;
                SelectData8 selectData8 = null;
                SelectData9 selectData9 = null;
                SelectData10 selectData10 = null;
                SelectData11 selectData11 = null;
                SelectData12 selectData12 = null;
                SelectData13 selectData13 = null;
                SelectData14 selectData14 = null;
                SelectData15 selectData15 = null;
                SelectData16 selectData16 = null;
                SelectData17 selectData17 = null;
                SelectData18 selectData18 = null;
                SelectData19 selectData19 = null;
                SelectData20 selectData20 = null;
                try {
                    selectData1 = new SelectData1();
                    selectData2 = new SelectData2();
                    selectData3 = new SelectData3();
                    selectData4 = new SelectData4();
                    selectData5 = new SelectData5();
                    selectData6 = new SelectData6();
                    selectData7 = new SelectData7();
                    selectData8 = new SelectData8();
                    selectData9 = new SelectData9();
                    selectData10 = new SelectData10();
                    selectData11 = new SelectData11();
                    selectData12 = new SelectData12();
                    selectData13 = new SelectData13();
                    selectData14 = new SelectData14();
                    selectData15 = new SelectData15();
                    selectData16 = new SelectData16();
                    selectData17 = new SelectData17();
                    selectData18 = new SelectData18();
                    selectData19 = new SelectData19();
                    selectData20 = new SelectData20();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                mapTableAndAxis.clear();

                arrayAxisT1[0]= String.valueOf(selectData1.getAxis1());
                arrayAxisT1[1]= String.valueOf(selectData1.getAxis2());
                arrayAxisT1[2]= String.valueOf(selectData1.getAxis3());
                arrayAxisT1[3]= String.valueOf(selectData1.getAxis4());
                arrayAxisT1[4]= selectData1.getLatitude();
                arrayAxisT1[5]= selectData1.getLongitude();
                arrayAxisT1[6]= "1t";
                mapTableAndAxis.put("1t",arrayAxisT1);


                arrayAxisT2[0]= String.valueOf(selectData2.getAxis1());
                arrayAxisT2[1]= String.valueOf(selectData2.getAxis2());
                arrayAxisT2[2]= String.valueOf(selectData2.getAxis3());
                arrayAxisT2[3]= String.valueOf(selectData2.getAxis4());
                arrayAxisT2[4]= selectData2.getLatitude();
                arrayAxisT2[5]= selectData2.getLongitude();
                arrayAxisT2[6]= "2t";
                mapTableAndAxis.put("2t",arrayAxisT2);

                arrayAxisT3[0]= String.valueOf(selectData3.getAxis1());
                arrayAxisT3[1]= String.valueOf(selectData3.getAxis2());
                arrayAxisT3[2]= String.valueOf(selectData3.getAxis3());
                arrayAxisT3[3]= String.valueOf(selectData3.getAxis4());
                arrayAxisT3[4]= selectData3.getLatitude();
                arrayAxisT3[5]= selectData3.getLongitude();
                arrayAxisT3[6]= "3t";
                mapTableAndAxis.put("3t",arrayAxisT3);


                arrayAxisT4[0]= String.valueOf(selectData4.getAxis1());
                arrayAxisT4[1]= String.valueOf(selectData4.getAxis2());
                arrayAxisT4[2]= String.valueOf(selectData4.getAxis3());
                arrayAxisT4[3]= String.valueOf(selectData4.getAxis4());
                arrayAxisT4[4]= selectData4.getLatitude();
                arrayAxisT4[5]= selectData4.getLongitude();
                arrayAxisT4[6]= "4t";
                mapTableAndAxis.put("4t",arrayAxisT4);

                arrayAxisT5[0]= String.valueOf(selectData5.getAxis1());
                arrayAxisT5[1]= String.valueOf(selectData5.getAxis2());
                arrayAxisT5[2]= String.valueOf(selectData5.getAxis3());
                arrayAxisT5[3]= String.valueOf(selectData5.getAxis4());
                arrayAxisT5[4]= selectData5.getLatitude();
                arrayAxisT5[5]= selectData5.getLongitude();
                arrayAxisT5[6]= "5t";
                mapTableAndAxis.put("5t",arrayAxisT5);


                arrayAxisT6[0]= String.valueOf(selectData6.getAxis1());
                arrayAxisT6[1]= String.valueOf(selectData6.getAxis2());
                arrayAxisT6[2]= String.valueOf(selectData6.getAxis3());
                arrayAxisT6[3]= String.valueOf(selectData6.getAxis4());
                arrayAxisT6[4]= selectData6.getLatitude();
                arrayAxisT6[5]= selectData6.getLongitude();
                arrayAxisT6[6]= "6t";
                mapTableAndAxis.put("6t",arrayAxisT6);

                arrayAxisT7[0]= String.valueOf(selectData7.getAxis1());
                arrayAxisT7[1]= String.valueOf(selectData7.getAxis2());
                arrayAxisT7[2]= String.valueOf(selectData7.getAxis3());
                arrayAxisT7[3]= String.valueOf(selectData7.getAxis4());
                arrayAxisT7[4]= selectData7.getLatitude();
                arrayAxisT7[5]= selectData7.getLongitude();
                arrayAxisT7[6]= "7t";
                mapTableAndAxis.put("7t",arrayAxisT7);


                arrayAxisT8[0]= String.valueOf(selectData8.getAxis1());
                arrayAxisT8[1]= String.valueOf(selectData8.getAxis2());
                arrayAxisT8[2]= String.valueOf(selectData8.getAxis3());
                arrayAxisT8[3]= String.valueOf(selectData8.getAxis4());
                arrayAxisT8[4]= selectData8.getLatitude();
                arrayAxisT8[5]= selectData8.getLongitude();
                arrayAxisT8[6]= "8t";
                mapTableAndAxis.put("8t",arrayAxisT8);

                arrayAxisT9[0]= String.valueOf(selectData9.getAxis1());
                arrayAxisT9[1]= String.valueOf(selectData9.getAxis2());
                arrayAxisT9[2]= String.valueOf(selectData9.getAxis3());
                arrayAxisT9[3]= String.valueOf(selectData9.getAxis4());
                arrayAxisT9[4]= selectData9.getLatitude();
                arrayAxisT9[5]= selectData9.getLongitude();
                arrayAxisT9[6]= "9t";
                mapTableAndAxis.put("9t",arrayAxisT9);


                arrayAxisT10[0]= String.valueOf(selectData10.getAxis1());
                arrayAxisT10[1]= String.valueOf(selectData10.getAxis2());
                arrayAxisT10[2]= String.valueOf(selectData10.getAxis3());
                arrayAxisT10[3]= String.valueOf(selectData10.getAxis4());
                arrayAxisT10[4]= selectData10.getLatitude();
                arrayAxisT10[5]= selectData10.getLongitude();
                arrayAxisT10[6]= "10t";
                mapTableAndAxis.put("10t",arrayAxisT10);

                arrayAxisT11[0]= String.valueOf(selectData11.getAxis1());
                arrayAxisT11[1]= String.valueOf(selectData11.getAxis2());
                arrayAxisT11[2]= String.valueOf(selectData11.getAxis3());
                arrayAxisT11[3]= String.valueOf(selectData11.getAxis4());
                arrayAxisT11[4]= selectData11.getLatitude();
                arrayAxisT11[5]= selectData11.getLongitude();
                arrayAxisT11[6]= "11t";
                mapTableAndAxis.put("11t",arrayAxisT11);


                arrayAxisT12[0]= String.valueOf(selectData12.getAxis1());
                arrayAxisT12[1]= String.valueOf(selectData12.getAxis2());
                arrayAxisT12[2]= String.valueOf(selectData12.getAxis3());
                arrayAxisT12[3]= String.valueOf(selectData12.getAxis4());
                arrayAxisT12[4]= selectData12.getLatitude();
                arrayAxisT12[5]= selectData12.getLongitude();
                arrayAxisT12[6]= "12t";
                mapTableAndAxis.put("12t",arrayAxisT12);

                arrayAxisT13[0]= String.valueOf(selectData13.getAxis1());
                arrayAxisT13[1]= String.valueOf(selectData13.getAxis2());
                arrayAxisT13[2]= String.valueOf(selectData13.getAxis3());
                arrayAxisT13[3]= String.valueOf(selectData13.getAxis4());
                arrayAxisT13[4]= selectData13.getLatitude();
                arrayAxisT13[5]= selectData13.getLongitude();
                arrayAxisT13[6]= "13t";
                mapTableAndAxis.put("13t",arrayAxisT13);


                arrayAxisT14[0]= String.valueOf(selectData14.getAxis1());
                arrayAxisT14[1]= String.valueOf(selectData14.getAxis2());
                arrayAxisT14[2]= String.valueOf(selectData14.getAxis3());
                arrayAxisT14[3]= String.valueOf(selectData14.getAxis4());
                arrayAxisT14[4]= selectData14.getLatitude();
                arrayAxisT14[5]= selectData14.getLongitude();
                arrayAxisT14[6]= "14t";
                mapTableAndAxis.put("14t",arrayAxisT14);

                arrayAxisT15[0]= String.valueOf(selectData15.getAxis1());
                arrayAxisT15[1]= String.valueOf(selectData15.getAxis2());
                arrayAxisT15[2]= String.valueOf(selectData15.getAxis3());
                arrayAxisT15[3]= String.valueOf(selectData15.getAxis4());
                arrayAxisT15[4]= selectData15.getLatitude();
                arrayAxisT15[5]= selectData15.getLongitude();
                arrayAxisT15[6]= "15t";
                mapTableAndAxis.put("15t",arrayAxisT15);


                arrayAxisT16[0]= String.valueOf(selectData16.getAxis1());
                arrayAxisT16[1]= String.valueOf(selectData16.getAxis2());
                arrayAxisT16[2]= String.valueOf(selectData16.getAxis3());
                arrayAxisT16[3]= String.valueOf(selectData16.getAxis4());
                arrayAxisT16[4]= selectData16.getLatitude();
                arrayAxisT16[5]= selectData16.getLongitude();
                arrayAxisT16[6]= "16t";
                mapTableAndAxis.put("16t",arrayAxisT16);

                arrayAxisT17[0]= String.valueOf(selectData17.getAxis1());
                arrayAxisT17[1]= String.valueOf(selectData17.getAxis2());
                arrayAxisT17[2]= String.valueOf(selectData17.getAxis3());
                arrayAxisT17[3]= String.valueOf(selectData17.getAxis4());
                arrayAxisT17[4]= selectData17.getLatitude();
                arrayAxisT17[5]= selectData17.getLongitude();
                arrayAxisT17[6]= "17t";
                mapTableAndAxis.put("17t",arrayAxisT17);


                arrayAxisT18[0]= String.valueOf(selectData18.getAxis1());
                arrayAxisT18[1]= String.valueOf(selectData18.getAxis2());
                arrayAxisT18[2]= String.valueOf(selectData18.getAxis3());
                arrayAxisT18[3]= String.valueOf(selectData18.getAxis4());
                arrayAxisT18[4]= selectData18.getLatitude();
                arrayAxisT18[5]= selectData18.getLongitude();
                arrayAxisT18[6]= "18t";
                mapTableAndAxis.put("18t",arrayAxisT18);

                arrayAxisT19[0]= String.valueOf(selectData19.getAxis1());
                arrayAxisT19[1]= String.valueOf(selectData19.getAxis2());
                arrayAxisT19[2]= String.valueOf(selectData19.getAxis3());
                arrayAxisT19[3]= String.valueOf(selectData19.getAxis4());
                arrayAxisT19[4]= selectData19.getLatitude();
                arrayAxisT19[5]= selectData19.getLongitude();
                arrayAxisT19[6]= "19t";
                mapTableAndAxis.put("19t",arrayAxisT19);


                arrayAxisT20[0]= String.valueOf(selectData20.getAxis1());
                arrayAxisT20[1]= String.valueOf(selectData20.getAxis2());
                arrayAxisT20[2]= String.valueOf(selectData20.getAxis3());
                arrayAxisT20[3]= String.valueOf(selectData20.getAxis4());
                arrayAxisT20[4]= selectData20.getLatitude();
                arrayAxisT20[5]= selectData20.getLongitude();
                arrayAxisT20[6]= "20t";
                mapTableAndAxis.put("20t",arrayAxisT20);

                ObjectOutputStream out = null;
                try {
                    out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                    out.writeObject(mapTableAndAxis);
                } catch ( IOException ex ) {
                    ex.printStackTrace();
                }
                out.flush();
                System.out.println("Отправили обьект");
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    clientSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
