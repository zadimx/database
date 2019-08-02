package com.navareno.data.AccessServer.Update;

import com.navareno.data.DB.Select.SelectData1;
import com.navareno.data.DB.Update.UpdateData1;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class UpdateTable1 {

    public UpdateTable1(ArrayList<String> arrayListAxis, String[] subStrNew, String[] subStr, String[] subStrGPS, String[] subStrGPSNew, Socket clientSocket, String string, int weight, UpdateData1 updateData1,
                        int weightNumberSensor, int weightData, int weightData1, int weightData2, int weightData3, int weightData4, OutputStream outputStream) {
        if (string.contains("$GNRMC") || string.contains("$GNVTG") || string.contains("$GNGGA") || string.contains("$GPGSV") || string.contains("$GNGLL")) {
            if (subStr.length <= 15) {
                System.out.println("Девайс отправил данные");
                for (int j = 0; j < subStr.length; j++) {
                    subStrNew[j] = subStr[j].replaceAll("\\s+", "");
                }

                for (String x: subStrNew) {
                    if (NumberUtils.isDigits(x)) {
                        arrayListAxis.add(x);
                    }
                }
                try {

                    if (subStrGPS[2] != null && subStrGPS[4] != null && !subStrGPS[2].isEmpty() && !subStrGPS[4].isEmpty()) {
                        subStrGPSNew[0] = subStrGPS[2];
                        subStrGPSNew[1] = subStrGPS[4];

                        System.out.println(subStrGPS[2]+subStrGPS[4]+"GPS");
                    }
                    else {
                        SelectData1 data = null;
                        try {
                            data = new SelectData1();
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                        subStrGPSNew[0] = data.getLongitude();
                        subStrGPSNew[1] = data.getLatitude();
                        System.out.println(subStrGPSNew[0]+subStrGPSNew[1]+"New");
                    }
                }
                catch (NullPointerException e)
                {
                    System.out.println("Hello_NULL");
                }
                for (int j = 0; j < arrayListAxis.size(); j++) {
                    try {
                        try {
                            weight = Integer.parseInt(arrayListAxis.get(j));
                            weightNumberSensor = (0xffff0000 & weight) >> 16;
                            weightData = 0x0000ffff & weight;
                            weightData = (int) (-862.5 + 1.725 * weightData);
                            if (weightNumberSensor == 1) {
                                weightData1 = weightData;

                                updateData1 = new UpdateData1(weightData1, weightData2, weightData3, weightData4, subStrGPSNew[0]+"", subStrGPSNew[1]+"");
                                updateData1.getConnection().close();

                            }
                            if (weightNumberSensor == 2) {
                                weightData2 = weightData;
                                updateData1 = new UpdateData1(weightData1, weightData2, weightData3, weightData4, subStrGPSNew[0]+"", subStrGPSNew[1]+"");
                                updateData1.getConnection().close();
                            }
                            if (weightNumberSensor == 3) {
                                weightData3 = weightData;
                                updateData1 = new UpdateData1(weightData1, weightData2, weightData3, weightData4, subStrGPSNew[0]+"", subStrGPSNew[1]+"");
                                updateData1.getConnection().close();
                            }
                            if (weightNumberSensor == 4) {
                                weightData4 = weightData;
                                updateData1 = new UpdateData1(weightData1, weightData2, weightData3, weightData4, subStrGPSNew[0]+"", subStrGPSNew[1]+"");
                                updateData1.getConnection().close();
                            }


                            if (arrayListAxis.size()-1 == j) {
                                arrayListAxis.clear();
                            }
                            System.out.println("получили номер датчика: " + weightNumberSensor + " данные с датчика: " + weightData);
                        }
                        catch (NumberFormatException e) {
                            System.out.println("Юра пидар! оправил вот эту хкйню " + "");
                        }
                        catch (SQLException e) {
                            System.out.println("Hello 13 "+e.getMessage());
                            try {
                                clientSocket.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            break;
                        }
//                                            else if (countWhat == -1) {
//                                                System.out.println("close socket");
//                                                clientSocket.close();
//                                                break;
//                                            }
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
