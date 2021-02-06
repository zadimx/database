package com.navareno.data.AccessServer.Insert;

import com.navareno.data.DB.Insert.InsertData1;
import com.navareno.data.DB.Select.SelectData1;
import com.navareno.data.DB.Update.UpdateData1;
import com.navareno.data.Server.ConnectionWorker;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;

public class InsertTable1 extends Socket {

    public InsertTable1(ArrayList<String> arrayListAxis, String[] subStrNew, String[] subStr, String[] subStrGPS, String[] subStrGPSNew, Socket clientSocket, String string, int weight, InsertData1 insertData1,
                        int weightNumberSensor, int weightData, int[] weightData1, int weightData2, int weightData3, int weightData4, OutputStream outputStream) {

        if (string.contains("$GNRMC") || string.contains("$GNVTG") || string.contains("$GNGGA") || string.contains("$GPGSV") || string.contains("$GNGLL")) {
            if (subStr.length <= 15) {
                weightData1 = new int[4];
                System.out.println("Девайс отправил данные");
                for (int j = 0; j < subStr.length; j++) {
                    subStrNew[j] = subStr[j].replaceAll("\\s+", "");
                }

                for (String x : subStrNew) {
                    if (NumberUtils.isDigits(x)) {
                        arrayListAxis.add(x);
                    }
                }
                try {

                    if (subStrGPS[2] != null && subStrGPS[4] != null && !subStrGPS[2].isEmpty() && !subStrGPS[4].isEmpty() && subStrGPS[2] != "null" && subStrGPS[4] != "null") {
                        subStrGPSNew[0] = subStrGPS[2];
                        subStrGPSNew[1] = subStrGPS[4];
                        new ConnectionWorker(this).setSubStrGPS();
                        System.out.println(subStrGPS[2] + subStrGPS[4] + " GPS New");
                    } else {
                        SelectData1 data = null;
                        try {
                            data = new SelectData1();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        subStrGPSNew[0] = "49.836197";
                        subStrGPSNew[1] = "23.999193";
                        System.out.println(subStrGPSNew[0] + subStrGPSNew[1] + " GPS Old");
                    }
                } catch (NullPointerException e) {
                    System.out.println("Hello_NULL");
                }
                for (int j = 0; j < arrayListAxis.size(); j++) {
                    try {
                        try {
                            weight = Integer.parseInt(arrayListAxis.get(j));
                            weightNumberSensor = (0xffff0000 & weight) >> 16;
                            weightData = 0x0000ffff & weight;
//                            weightData = (int) (-862.5 + 1.725 * weightData);
//                            System.out.println( weight+" "+weightNumberSensor+" "+weightData);
                            System.out.println("получили номер датчика: " + weightNumberSensor + " данные с датчика: " + weightData);
                            if (weightNumberSensor == 1) {
                                weightData1[weightNumberSensor - 1] = weightData;
//                                if (weightData1[0] != 0) {
//                                    insertData1 = new InsertData1(weightData1[0], 0, 0, 0, subStrGPSNew[0] + "", subStrGPSNew[1] + "");
//                                    insertData1.getConnection().close();
//                                }

                            }
                            if (weightNumberSensor == 2) {
                                weightData1[weightNumberSensor - 1] = weightData;
//                                if (weightData1[0] != 0 && weightData1[1] != 0) {
//                                    insertData1 = new InsertData1(weightData1[0], weightData1[1], 0, 0, subStrGPSNew[0] + "", subStrGPSNew[1] + "");
//                                    insertData1.getConnection().close();
//                                }
                            }
                            if (weightNumberSensor == 3) {
                                weightData1[weightNumberSensor - 1] = weightData;
//                                if (weightData1[0] != 0 && weightData1[1] != 0 && weightData1[2] != 0) {
//                                    insertData1 = new InsertData1(weightData1[0], weightData1[1], weightData1[2], 0, subStrGPSNew[0] + "", subStrGPSNew[1] + "");
//                                    insertData1.getConnection().close();
//                                }
                            }
                            if (weightNumberSensor == 4) {
                                weightData1[weightNumberSensor - 1] = weightData;
//                                if (weightData1[0] != 0 && weightData1[1] != 0 && weightData1[2] != 0 && weightData1[3] != 0) {
//                                    insertData1 = new InsertData1(weightData1[0], weightData1[1], weightData1[2], weightData1[3], subStrGPSNew[0] + "", subStrGPSNew[1] + "");
//                                    insertData1.getConnection().close();
//                                }
                            }



                            if (arrayListAxis.size() - 1 == j) {
                                arrayListAxis.clear();
                            }

                        } catch (NumberFormatException e) {
                            System.out.println("Юра пидар! оправил вот эту хкйню " + "");
                        }
                    } catch (Exception e) {
                        System.out.println("Hello 8 " + e.getMessage());
                        try {
                            clientSocket.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }
                }
                try {
                    if (weightData1[0] != 0 && weightData1[1] != 0 && weightData1[2] != 0 && weightData1[3] != 0) {
                        insertData1 = new InsertData1(weightData1[0], weightData1[1], weightData1[2], weightData1[3], subStrGPSNew[0] + "", subStrGPSNew[1] + "");
                        insertData1.getConnection().close();
                    }
                    else{
                        System.out.println("Какойто из датчиков выдает 0");
                    }
                } catch(SQLException throwables){
                    throwables.printStackTrace();
                }
                try {
                    outputStream.write(("done".getBytes()));
                    outputStream.flush();
                } catch (IOException e) {
                    System.out.println("Hello 9 "+e.getMessage());
                    try {
                        clientSocket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }

            }
        }
    }
}