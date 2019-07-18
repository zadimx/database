package com.navareno.data.Server;

import com.navareno.data.DB.Select.*;
import com.navareno.data.DB.Update.UpdateData1;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Created by Max on 15.07.2017.
 */
public class ConnectionWorker implements Runnable, Serializable {
    /* сокет, через который происходит обмен данными с клиентом*/
    String[] subStrGPS = new String[15];
    String[] subStrGPSNew = new String[2];
    private static String text = "";
    private Socket clientSocket;
    public static long i = 0;
    public String string;
    public String stringWhat;
    public int countArrayAxis;
    public static String string1;
    public static int weight;
    public static UpdateData1 updateData1;
    public static int weightNumberSensor;
    public static int weightData;
    public static int weightData1;
    public static int weightData2;
    public static int weightData3;
    public static int weightData4;
    public static int weight1;
    private static final String[] pass = {"a1","a2","a3"};
    /* входной поток, через который получаем данные с сокета */
    private InputStream inputStream = null;
    private OutputStream outputStream = null;
    private ObjectOutputStream objectOutputStream = null;
    private HashMap<String, String[]> mapTableAndAxis = new HashMap<>();
    private String[] arrayAxisT1 = new String[6];
    private String[] arrayAxisT2 = new String[6];
    private String[] arrayAxisT3 = new String[6];
    private String[] arrayAxisT4 = new String[6];
    private String[] arrayAxisT5 = new String[6];
    private String[] arrayAxisT6 = new String[6];
    private String[] arrayAxisT7 = new String[6];
    private String[] arrayAxisT8 = new String[6];
    private String[] arrayAxisT9 = new String[6];
    private String[] arrayAxisT10 = new String[6];
    private String[] arrayAxisT11 = new String[6];
    private String[] arrayAxisT12 = new String[6];
    private String[] arrayAxisT13 = new String[6];
    private String[] arrayAxisT14 = new String[6];
    private String[] arrayAxisT15 = new String[6];
    private String[] arrayAxisT16 = new String[6];
    private String[] arrayAxisT17 = new String[6];
    private String[] arrayAxisT18 = new String[6];
    private String[] arrayAxisT19 = new String[6];
    private String[] arrayAxisT20 = new String[6];

    private static int countRead=0;


    public static int getCountRead() {
        return countRead;
    }

    public ConnectionWorker(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try {
            SelectData3 selectData3 = new SelectData3();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /* получаем входной поток */
        try {
            InetSocketAddress sockaddr = (InetSocketAddress)clientSocket.getRemoteSocketAddress();
            String gh = String.valueOf(sockaddr.getAddress());
            System.out.println(sockaddr.getAddress());
//            if (gh.equals("/37.73.249.54") || gh.equals("/37.73.139.15") || gh.equals("/37.73.247.217")) {
            inputStream = clientSocket.getInputStream();
            outputStream = clientSocket.getOutputStream();
//            }
//            else {
//                System.out.println("close socket");
//                clientSocket.close();
//            }
//            System.out.println("Get client connection "+ clientSocket.getRemoteSocketAddress().toString());
//            System.out.println("Get client connection "+ InetAddress.getLocalHost().toString());

        } catch (IOException e) {
            System.out.println("Cant get input stream");
        }

        /* создаем буфер для данных */
        byte[] buffer = new byte[1024*4];

        while(!clientSocket.isClosed()) {

            try {
                /*
                 * получаем очередную порцию данных
                 * в переменной count хранится реальное количество байт, которое получили
                 */

                int count = 0;
                try {
                    count = inputStream.read(buffer,0,buffer.length);
                } catch (IOException e) {
                    System.out.println("Hello 1 "+e.getMessage());
                    try {
                        clientSocket.close();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    break;
                }
                /* проверяем, какое количество байт к нам прийшло */
                if (count > 0) {
                    string = new String(buffer,0,count);
                    i++;
                    string1=string;
                    String str = string;
                    String[] subStr;

                    ArrayList<String> arrayListAxis = new ArrayList<>();
                    String delimeter = "\n"; // Разделитель
                    subStr = str.split(delimeter);
                    String[] subStrNew = new String[subStr.length];

                    System.out.println(subStr.length);
                    for (String a: subStr
                    ) {
                        if (a.contains("$GNGGA") ) {
                            subStrGPS = a.split(",");
                        }
                    }

//                    try(FileWriter writer = new FileWriter("notes3.txt", false))
//                    {
//                        // запись всей строки
//                        text = text +"^^@^^ "+ string;
//                        writer.write(text);
//                        // запись по символам
//                        writer.flush();
//                    }
//                    catch(IOException ex){
//                        System.out.println("Hello "+ex.getMessage());
//                    }

                    System.out.println("получили "+string);
                                if (string.equals(pass[0]+"db")) {
                                    if (subStrNew == null) {

                                    }
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
                                        mapTableAndAxis.put("1t",arrayAxisT1);


                                        arrayAxisT2[0]= String.valueOf(selectData2.getAxis1());
                                        arrayAxisT2[1]= String.valueOf(selectData2.getAxis2());
                                        arrayAxisT2[2]= String.valueOf(selectData2.getAxis3());
                                        arrayAxisT2[3]= String.valueOf(selectData2.getAxis4());
                                        arrayAxisT2[4]= selectData2.getLatitude();
                                        arrayAxisT2[5]= selectData2.getLongitude();
                                        mapTableAndAxis.put("2t",arrayAxisT2);

                                        arrayAxisT3[0]= String.valueOf(selectData3.getAxis1());
                                        arrayAxisT3[1]= String.valueOf(selectData3.getAxis2());
                                        arrayAxisT3[2]= String.valueOf(selectData3.getAxis3());
                                        arrayAxisT3[3]= String.valueOf(selectData3.getAxis4());
                                        arrayAxisT3[4]= selectData3.getLatitude();
                                        arrayAxisT3[5]= selectData3.getLongitude();
                                        mapTableAndAxis.put("3t",arrayAxisT3);


                                        arrayAxisT4[0]= String.valueOf(selectData4.getAxis1());
                                        arrayAxisT4[1]= String.valueOf(selectData4.getAxis2());
                                        arrayAxisT4[2]= String.valueOf(selectData4.getAxis3());
                                        arrayAxisT4[3]= String.valueOf(selectData4.getAxis4());
                                        arrayAxisT4[4]= selectData4.getLatitude();
                                        arrayAxisT4[5]= selectData4.getLongitude();
                                        mapTableAndAxis.put("4t",arrayAxisT4);

                                        arrayAxisT5[0]= String.valueOf(selectData5.getAxis1());
                                        arrayAxisT5[1]= String.valueOf(selectData5.getAxis2());
                                        arrayAxisT5[2]= String.valueOf(selectData5.getAxis3());
                                        arrayAxisT5[3]= String.valueOf(selectData5.getAxis4());
                                        arrayAxisT5[4]= selectData5.getLatitude();
                                        arrayAxisT5[5]= selectData5.getLongitude();
                                        mapTableAndAxis.put("5t",arrayAxisT5);


                                        arrayAxisT6[0]= String.valueOf(selectData6.getAxis1());
                                        arrayAxisT6[1]= String.valueOf(selectData6.getAxis2());
                                        arrayAxisT6[2]= String.valueOf(selectData6.getAxis3());
                                        arrayAxisT6[3]= String.valueOf(selectData6.getAxis4());
                                        arrayAxisT6[4]= selectData6.getLatitude();
                                        arrayAxisT6[5]= selectData6.getLongitude();
                                        mapTableAndAxis.put("6t",arrayAxisT6);

                                        arrayAxisT7[0]= String.valueOf(selectData7.getAxis1());
                                        arrayAxisT7[1]= String.valueOf(selectData7.getAxis2());
                                        arrayAxisT7[2]= String.valueOf(selectData7.getAxis3());
                                        arrayAxisT7[3]= String.valueOf(selectData7.getAxis4());
                                        arrayAxisT7[4]= selectData7.getLatitude();
                                        arrayAxisT7[5]= selectData7.getLongitude();
                                        mapTableAndAxis.put("7t",arrayAxisT7);


                                        arrayAxisT8[0]= String.valueOf(selectData8.getAxis1());
                                        arrayAxisT8[1]= String.valueOf(selectData8.getAxis2());
                                        arrayAxisT8[2]= String.valueOf(selectData8.getAxis3());
                                        arrayAxisT8[3]= String.valueOf(selectData8.getAxis4());
                                        arrayAxisT8[4]= selectData8.getLatitude();
                                        arrayAxisT8[5]= selectData8.getLongitude();
                                        mapTableAndAxis.put("8t",arrayAxisT8);

                                        arrayAxisT9[0]= String.valueOf(selectData9.getAxis1());
                                        arrayAxisT9[1]= String.valueOf(selectData9.getAxis2());
                                        arrayAxisT9[2]= String.valueOf(selectData9.getAxis3());
                                        arrayAxisT9[3]= String.valueOf(selectData9.getAxis4());
                                        arrayAxisT9[4]= selectData9.getLatitude();
                                        arrayAxisT9[5]= selectData9.getLongitude();
                                        mapTableAndAxis.put("9t",arrayAxisT9);


                                        arrayAxisT10[0]= String.valueOf(selectData10.getAxis1());
                                        arrayAxisT10[1]= String.valueOf(selectData10.getAxis2());
                                        arrayAxisT10[2]= String.valueOf(selectData10.getAxis3());
                                        arrayAxisT10[3]= String.valueOf(selectData10.getAxis4());
                                        arrayAxisT10[4]= selectData10.getLatitude();
                                        arrayAxisT10[5]= selectData10.getLongitude();
                                        mapTableAndAxis.put("10t",arrayAxisT2);

                                        arrayAxisT11[0]= String.valueOf(selectData11.getAxis1());
                                        arrayAxisT11[1]= String.valueOf(selectData11.getAxis2());
                                        arrayAxisT11[2]= String.valueOf(selectData11.getAxis3());
                                        arrayAxisT11[3]= String.valueOf(selectData11.getAxis4());
                                        arrayAxisT11[4]= selectData11.getLatitude();
                                        arrayAxisT11[5]= selectData11.getLongitude();
                                        mapTableAndAxis.put("11t",arrayAxisT11);


                                        arrayAxisT12[0]= String.valueOf(selectData12.getAxis1());
                                        arrayAxisT12[1]= String.valueOf(selectData12.getAxis2());
                                        arrayAxisT12[2]= String.valueOf(selectData12.getAxis3());
                                        arrayAxisT12[3]= String.valueOf(selectData12.getAxis4());
                                        arrayAxisT12[4]= selectData12.getLatitude();
                                        arrayAxisT12[5]= selectData12.getLongitude();
                                        mapTableAndAxis.put("12t",arrayAxisT12);

                                        arrayAxisT13[0]= String.valueOf(selectData13.getAxis1());
                                        arrayAxisT13[1]= String.valueOf(selectData13.getAxis2());
                                        arrayAxisT13[2]= String.valueOf(selectData13.getAxis3());
                                        arrayAxisT13[3]= String.valueOf(selectData13.getAxis4());
                                        arrayAxisT13[4]= selectData13.getLatitude();
                                        arrayAxisT13[5]= selectData13.getLongitude();
                                        mapTableAndAxis.put("13t",arrayAxisT13);


                                        arrayAxisT14[0]= String.valueOf(selectData14.getAxis1());
                                        arrayAxisT14[1]= String.valueOf(selectData14.getAxis2());
                                        arrayAxisT14[2]= String.valueOf(selectData14.getAxis3());
                                        arrayAxisT14[3]= String.valueOf(selectData14.getAxis4());
                                        arrayAxisT14[4]= selectData14.getLatitude();
                                        arrayAxisT14[5]= selectData14.getLongitude();
                                        mapTableAndAxis.put("14t",arrayAxisT14);

                                        arrayAxisT15[0]= String.valueOf(selectData15.getAxis1());
                                        arrayAxisT15[1]= String.valueOf(selectData15.getAxis2());
                                        arrayAxisT15[2]= String.valueOf(selectData15.getAxis3());
                                        arrayAxisT15[3]= String.valueOf(selectData15.getAxis4());
                                        arrayAxisT15[4]= selectData15.getLatitude();
                                        arrayAxisT15[5]= selectData15.getLongitude();
                                        mapTableAndAxis.put("15t",arrayAxisT15);


                                        arrayAxisT16[0]= String.valueOf(selectData16.getAxis1());
                                        arrayAxisT16[1]= String.valueOf(selectData16.getAxis2());
                                        arrayAxisT16[2]= String.valueOf(selectData16.getAxis3());
                                        arrayAxisT16[3]= String.valueOf(selectData16.getAxis4());
                                        arrayAxisT16[4]= selectData16.getLatitude();
                                        arrayAxisT16[5]= selectData16.getLongitude();
                                        mapTableAndAxis.put("16t",arrayAxisT16);

                                        arrayAxisT17[0]= String.valueOf(selectData17.getAxis1());
                                        arrayAxisT17[1]= String.valueOf(selectData17.getAxis2());
                                        arrayAxisT17[2]= String.valueOf(selectData17.getAxis3());
                                        arrayAxisT17[3]= String.valueOf(selectData17.getAxis4());
                                        arrayAxisT17[4]= selectData17.getLatitude();
                                        arrayAxisT17[5]= selectData17.getLongitude();
                                        mapTableAndAxis.put("17t",arrayAxisT17);


                                        arrayAxisT18[0]= String.valueOf(selectData18.getAxis1());
                                        arrayAxisT18[1]= String.valueOf(selectData18.getAxis2());
                                        arrayAxisT18[2]= String.valueOf(selectData18.getAxis3());
                                        arrayAxisT18[3]= String.valueOf(selectData18.getAxis4());
                                        arrayAxisT18[4]= selectData18.getLatitude();
                                        arrayAxisT18[5]= selectData18.getLongitude();
                                        mapTableAndAxis.put("18t",arrayAxisT18);

                                        arrayAxisT19[0]= String.valueOf(selectData19.getAxis1());
                                        arrayAxisT19[1]= String.valueOf(selectData19.getAxis2());
                                        arrayAxisT19[2]= String.valueOf(selectData19.getAxis3());
                                        arrayAxisT19[3]= String.valueOf(selectData19.getAxis4());
                                        arrayAxisT19[4]= selectData19.getLatitude();
                                        arrayAxisT19[5]= selectData19.getLongitude();
                                        mapTableAndAxis.put("19t",arrayAxisT19);


                                        arrayAxisT20[0]= String.valueOf(selectData20.getAxis1());
                                        arrayAxisT20[1]= String.valueOf(selectData20.getAxis2());
                                        arrayAxisT20[2]= String.valueOf(selectData20.getAxis3());
                                        arrayAxisT20[3]= String.valueOf(selectData20.getAxis4());
                                        arrayAxisT20[4]= selectData20.getLatitude();
                                        arrayAxisT20[5]= selectData20.getLongitude();
                                        mapTableAndAxis.put("20t",arrayAxisT20);

                                        ObjectOutputStream out = null;
                                        try {
                                            out = new ObjectOutputStream(new BufferedOutputStream(clientSocket.getOutputStream()));
                                            out.writeObject(mapTableAndAxis);
                                        } catch ( IOException ex ) {
                                            ex.printStackTrace();
                                        }
                                        out.flush();
//                                        outputStream.write(("1t"+selectData1.getAxis1() + " "
//                                                + selectData1.getAxis2() + " "
//                                                + selectData1.getAxis3() + " "
//                                                + selectData1.getAxis4() +" "
//                                                + selectData1.getLatitude() +" "
//                                                + selectData1.getLongitude()).getBytes());
//                                        outputStream.flush();
                                        System.out.println("Отправили обьект");
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                        try {
                                            clientSocket.close();
                                        } catch (IOException e1) {
                                            e1.printStackTrace();
                                        }
                                        break;
                                    }
                                }
                        if (count == -1 ) {
                            System.out.println("close socket");
                            Server.setConect("Kaka");
                            try {
                                clientSocket.close();
                            } catch (IOException e) {
                                System.out.println("Hello 4 "+e.getMessage());
                                break;
                            }
                            break;
                        }
                    else if (Arrays.asList(pass).contains(string)) {
                        try {
                            outputStream.write(string.getBytes());
                            outputStream.flush();
                        } catch (IOException e) {
                            System.out.println("Hello 5 "+e.getMessage());
                            try {
                                clientSocket.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            break;
                        }

                        System.out.println("отправили "+ string);

                        string = null;
                    }
                    else if (string.equals("sgkjhcxk6543SlkjfB")&& string !="1t" && string != "2t") {
                        try {
                            outputStream.write(("done".getBytes()));
                            outputStream.flush();
                        } catch (IOException e) {
                            System.out.println("Hello 6 "+e.getMessage());
                            break;
                        }
//                        System.out.println("отправили "+ "done");

                        string = null;
                    }
                    else if (string.equals("SERIAL_NUM")&& !string.equals("1t") && !string.equals("2t")) {
                            System.out.println("******2*");
                        try {
                            outputStream.write(("done".getBytes()));
                            outputStream.flush();
                        } catch (IOException e) {
                            System.out.println("Hello 7 "+e.getMessage());
                            try {
                                clientSocket.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            break;
                        }
//                        System.out.println("отправили "+ "done");
                        string = null;
                    }

                    else if (subStr.length <= 15 && !string.equals(pass[0]+"db") && !string.equals(pass[0])) {
                            System.out.println("*******3");
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
                                SelectData1 data = new SelectData1();
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
                            break;
                        }
//                        System.out.println("отправили "+ "done");
                        string = null;
                    }
                    else if(!string.equals("1t") && !string.equals("2t")) {
                        try {
                            outputStream.write(("done".getBytes()));
                            outputStream.flush();
                        } catch (IOException e) {
                            System.out.println("Hello 10 "+e.getMessage());
                            try {
                                clientSocket.close();
                            } catch (IOException e1) {
                                e1.printStackTrace();
                            }
                            break;
                        }
//                        System.out.println("отправили "+ "done");

                        string = null;
                    }


                } else
                    /* если мы получили -1, значит прервался наш поток с данными  */
                    if (count == -1 ) {
                        System.out.println("close socket");
                        Server.setConect("Kaka");
                        try {
                            clientSocket.close();
                        } catch (IOException e) {
                            System.out.println("Hello 11 "+e.getMessage());
                            break;
                        }
                        break;
                    }

            } catch (SQLException e) {
                System.out.println("Hello 12 "+e.getMessage());
                try {
                    clientSocket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                break;
            }

        }
    }
}
