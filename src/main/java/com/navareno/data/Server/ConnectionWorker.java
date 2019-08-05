package com.navareno.data.Server;

import com.navareno.data.AccessServer.Select.SelectAccount1;
import com.navareno.data.AccessServer.Update.UpdateTable1;
import com.navareno.data.DB.Insert.InsertData1;
import com.navareno.data.DB.SelectDataTime.SelectDataTime1;
import com.navareno.data.DB.Update.UpdateData1;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/*
 * Created by Max on 15.07.2017.
 */
public class ConnectionWorker implements Runnable, Serializable {
    /* сокет, через который происходит обмен данными с клиентом*/
    private ArrayList<String> arrayListAxis;
    private String[] subStrNew;
    private String str;
    private String[] subStr;
    private String[] subStrGPS = new String[15];
    private String[] subStrGPSNew = new String[2];
    private Socket clientSocket;
    private String string;
    private int weight;
    private UpdateData1 updateData1;
    private int weightNumberSensor;
    private int weightData;
    private int weightData1;
    private int weightData2;
    private int weightData3;
    private int weightData4;
    private int weight1;
    private String[] pass = {"a1", "a2", "a3"};
    /* входной поток, через который получаем данные с сокета */
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private HashMap<String, String[]> mapTableAndAxis = new HashMap<>();
    private String[] arrayAxisT1 = new String[7];
    private String[] arrayAxisT2 = new String[7];
    private String[] arrayAxisT3 = new String[7];
    private String[] arrayAxisT4 = new String[7];
    private String[] arrayAxisT5 = new String[7];
    private String[] arrayAxisT6 = new String[7];
    private String[] arrayAxisT7 = new String[7];
    private String[] arrayAxisT8 = new String[7];
    private String[] arrayAxisT9 = new String[7];
    private String[] arrayAxisT10 = new String[7];
    private String[] arrayAxisT11 = new String[7];
    private String[] arrayAxisT12 = new String[7];
    private String[] arrayAxisT13 = new String[7];
    private String[] arrayAxisT14 = new String[7];
    private String[] arrayAxisT15 = new String[7];
    private String[] arrayAxisT16 = new String[7];
    private String[] arrayAxisT17 = new String[7];
    private String[] arrayAxisT18 = new String[7];
    private String[] arrayAxisT19 = new String[7];
    private String[] arrayAxisT20 = new String[7];


    public void setSubStrGPS() {
        this.subStrGPS[2] = null;
        this.subStrGPS[4] = null;
    }

    public String[] getSubStrGPS() {
        return subStrGPS;
    }

    public ConnectionWorker(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        /* получаем входной поток */
        try {
            InetSocketAddress sockaddr = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
            String gh = String.valueOf(sockaddr.getAddress());
            System.out.println(sockaddr.getAddress());
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();

        } catch (IOException e) {
            System.out.println("Cant get input stream");
        }

        /* создаем буфер для данных */
        byte[] buffer = new byte[1024 * 4];

        while (!clientSocket.isClosed()) {

            /*
             * получаем очередную порцию данных
             * в переменной count хранится реальное количество байт, которое получили
             */

            int count = 0;
            try {
                count = inputStream.read(buffer, 0, buffer.length);
            } catch (IOException e) {
                System.out.println("Hello 1 " + e.getMessage());
                try {
                    clientSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            }
            /* проверяем, какое количество байт к нам прийшло */
            if (count > 0) {
                string = new String(buffer, 0, count);
                str = string;
                arrayListAxis = new ArrayList<>();
                String delimeter = "\n"; // Разделитель
                subStr = str.split(delimeter);
                subStrNew = new String[subStr.length];

//              Парсинг строки геолокации
                for (String a : subStr
                ) {
                    if (a.contains("$GNGGA")) {
                        subStrGPS = a.split(",");
                        System.out.println(subStrGPS.toString());
                    }
                }

//    НАЧАЛО--------------------
                if (string.equals("hour")) {
                    SelectDataTime1 selectDataTime1 = null;
                    try {
                        selectDataTime1 = new SelectDataTime1();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime1.arrayHistoryValues());
                        } catch ( IOException ex ) {
                            ex.printStackTrace();
                        }
                        out.flush();
                    } catch (IOException e) {
                        System.out.println("Hello 2 "+e.getMessage());
                        try {
                            clientSocket.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }

                }
// ---------------------------------------------


                System.out.println("получили " + string);


//              Авторизация пользователя
                if (Arrays.asList(pass).contains(string)) {
                    try {
                        outputStream.write(string.getBytes());
                        outputStream.flush();
//                        try {
//                            new InsertData1(32,23,234,45,"546.456","45.456");
//                        } catch (SQLException e) {
//                            e.printStackTrace();
//                        }
                        System.out.println("Телефон залогинился");
                    } catch (IOException e) {
                        System.out.println("Hello 5 " + e.getMessage());
                        try {
                            clientSocket.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        break;
                    }
                }

//              Отправка данных на телефон
                new SelectAccount1(clientSocket, string, pass, mapTableAndAxis, arrayAxisT1, arrayAxisT2, arrayAxisT3, arrayAxisT4, arrayAxisT5, arrayAxisT6, arrayAxisT7, arrayAxisT8, arrayAxisT9, arrayAxisT10, arrayAxisT11,
                        arrayAxisT12, arrayAxisT13, arrayAxisT14, arrayAxisT15, arrayAxisT16, arrayAxisT17, arrayAxisT18, arrayAxisT19, arrayAxisT20);

//              Авторизация устройства
                if (string.equals("sgkjhcxk6543SlkjfB") || string.equals("SERIAL_NUM")) {
                    try {
                        outputStream.write(("done".getBytes()));
                        outputStream.flush();
                        System.out.println("Девайс залогинился");


                    } catch (IOException e) {
                        System.out.println("Hello 6 " + e.getMessage());
                        break;
                    }

                }

//              Обновление данных в таблице №1
                new UpdateTable1(arrayListAxis, subStrNew, subStr, subStrGPS, subStrGPSNew, clientSocket, string, weight, updateData1, weightNumberSensor, weightData, weightData1, weightData2, weightData3, weightData4, outputStream);

            } else
                /* если мы получили -1, значит прервался наш поток с данными  */
                if (count == -1) {
                    System.out.println("close socket");
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        System.out.println("Hello 11 " + e.getMessage());
                        break;
                    }
                    break;
                }

        }
    }
}
