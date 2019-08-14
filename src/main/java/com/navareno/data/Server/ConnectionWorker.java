package com.navareno.data.Server;

import com.navareno.data.AccessServer.Insert.InsertTable1;
import com.navareno.data.AccessServer.Select.SelectAccount1;
import com.navareno.data.AccessServer.Update.UpdateTable1;
import com.navareno.data.DB.Insert.InsertData1;
import com.navareno.data.DB.SelectDataTime.SelectDataTime1;
import com.navareno.data.DB.SelectDataTime.SelectDataTime2;
import com.navareno.data.DB.SelectDataTime.SelectDataTime3;
import com.navareno.data.DB.SelectDataTime.SelectDataTime4;
import com.navareno.data.DB.SelectDataTime.SelectDataTime5;
import com.navareno.data.DB.SelectDataTime.SelectDataTime6;
import com.navareno.data.DB.SelectDataTime.SelectDataTime7;
import com.navareno.data.DB.SelectDataTime.SelectDataTime8;
import com.navareno.data.DB.SelectDataTime.SelectDataTime9;
import com.navareno.data.DB.SelectDataTime.SelectDataTime10;
import com.navareno.data.DB.SelectDataTime.SelectDataTime11;
import com.navareno.data.DB.SelectDataTime.SelectDataTime12;
import com.navareno.data.DB.SelectDataTime.SelectDataTime13;
import com.navareno.data.DB.SelectDataTime.SelectDataTime14;
import com.navareno.data.DB.SelectDataTime.SelectDataTime15;
import com.navareno.data.DB.SelectDataTime.SelectDataTime16;
import com.navareno.data.DB.SelectDataTime.SelectDataTime17;
import com.navareno.data.DB.SelectDataTime.SelectDataTime18;
import com.navareno.data.DB.SelectDataTime.SelectDataTime19;
import com.navareno.data.DB.SelectDataTime.SelectDataTime20;
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
    private InsertData1 insertData1;
    private int weightNumberSensor;
    private int weightData;
    private int[] weightData1;
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
                if (string.equals("1t")) {
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


                //    НАЧАЛО--------------------
                if (string.equals("2t")) {
                    SelectDataTime2 selectDataTime2 = null;
                    try {
                        selectDataTime2 = new SelectDataTime2();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime2.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("3t")) {
                    SelectDataTime3 selectDataTime3 = null;
                    try {
                        selectDataTime3 = new SelectDataTime3();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime3.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("4t")) {
                    SelectDataTime4 selectDataTime4 = null;
                    try {
                        selectDataTime4 = new SelectDataTime4();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime4.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("5t")) {
                    SelectDataTime5 selectDataTime5 = null;
                    try {
                        selectDataTime5 = new SelectDataTime5();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime5.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("6t")) {
                    SelectDataTime6 selectDataTime6 = null;
                    try {
                        selectDataTime6 = new SelectDataTime6();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime6.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("7t")) {
                    SelectDataTime7 selectDataTime7 = null;
                    try {
                        selectDataTime7 = new SelectDataTime7();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime7.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("8t")) {
                    SelectDataTime8 selectDataTime8 = null;
                    try {
                        selectDataTime8 = new SelectDataTime8();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime8.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("9t")) {
                    SelectDataTime9 selectDataTime9 = null;
                    try {
                        selectDataTime9 = new SelectDataTime9();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime9.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("10t")) {
                    SelectDataTime10 selectDataTime10 = null;
                    try {
                        selectDataTime10 = new SelectDataTime10();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime10.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("11t")) {
                    SelectDataTime11 selectDataTime11 = null;
                    try {
                        selectDataTime11 = new SelectDataTime11();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime11.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("12t")) {
                    SelectDataTime12 selectDataTime12 = null;
                    try {
                        selectDataTime12 = new SelectDataTime12();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime12.arrayHistoryValues());
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



                //    НАЧАЛО--------------------
                if (string.equals("13t")) {
                    SelectDataTime13 selectDataTime13 = null;
                    try {
                        selectDataTime13 = new SelectDataTime13();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime13.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("14t")) {
                    SelectDataTime14 selectDataTime14 = null;
                    try {
                        selectDataTime14 = new SelectDataTime14();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime14.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("15t")) {
                    SelectDataTime15 selectDataTime15 = null;
                    try {
                        selectDataTime15 = new SelectDataTime15();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime15.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("16t")) {
                    SelectDataTime16 selectDataTime16 = null;
                    try {
                        selectDataTime16 = new SelectDataTime16();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime16.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("17t")) {
                    SelectDataTime17 selectDataTime17 = null;
                    try {
                        selectDataTime17 = new SelectDataTime17();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime17.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("18t")) {
                    SelectDataTime18 selectDataTime18 = null;
                    try {
                        selectDataTime18 = new SelectDataTime18();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime18.arrayHistoryValues());
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

                //    НАЧАЛО--------------------
                if (string.equals("19t")) {
                    SelectDataTime19 selectDataTime19 = null;
                    try {
                        selectDataTime19 = new SelectDataTime19();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime19.arrayHistoryValues());
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


                //    НАЧАЛО--------------------
                if (string.equals("20t")) {
                    SelectDataTime20 selectDataTime20 = null;
                    try {
                        selectDataTime20 = new SelectDataTime20();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    try {
                        ObjectOutputStream out = null;
                        try {
                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                            out.writeObject(selectDataTime20.arrayHistoryValues());
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
//                new UpdateTable1(arrayListAxis, subStrNew, subStr, subStrGPS, subStrGPSNew, clientSocket, string, weight, updateData1, weightNumberSensor, weightData, weightData1, weightData2, weightData3, weightData4, outputStream);
                new InsertTable1(arrayListAxis, subStrNew, subStr, subStrGPS, subStrGPSNew, clientSocket, string, weight, insertData1, weightNumberSensor, weightData, weightData1, weightData2, weightData3, weightData4, outputStream);

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
