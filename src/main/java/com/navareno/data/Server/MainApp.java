package com.navareno.data.Server;




import com.mysql.fabric.jdbc.FabricMySQLDriver;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Max on 15.07.2017.
 */
public class MainApp extends JFrame{
    static String a = "asd";
    static String b = "asd";
    private static String global;
    private static JLabel label = new JLabel("asd");
    private static JLabel label1 = new JLabel("asd");
    private static JLabel label2 = new JLabel("asd");
    private final JButton b1 = new JButton("Send");

    public static String getGlobal() {
        return global;
    }

    public MainApp(String name) {
        super(name);
        setLayout(new FlowLayout());
        global = "null";
        label.setText(global);
//        label1.setText("port: "+ Server.getServer().getSERVER_PORT());
//        label1.setText("port: "+ ConnectionWorker.getCountRead());
//        label2.setText(ConnectionWorker.string);
        setSize(300,150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocationRelativeTo(null);
        setAlwaysOnTop(true);


        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (arg0.getSource() == b1) {
                    Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
//                    try {
//                        global = (String) clpbrd.getData(DataFlavor.stringFlavor);
//                        label.setText("output: "+(new DBWorker()).getYyy());
                        SwingUtilities.invokeLater(new Runnable() {
                            public void run() {
//                                label2.setText("input: "+ Server.conect);
//                                label.setText(ConnectionWorker.string1);
//                                label1.setText("port: "+ ConnectionWorker.getCountRead());


//                                new UpdateData1(666);
                            }
                        });
//                    } catch (UnsupportedFlavorException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        });
        b1.setPreferredSize(new Dimension(250,80));
        b1.setBackground(Color.decode("#FFD700"));
        add(b1);
        add(label);
        add(label1);
        add(label2);
        setVisible(true);
    }
    public static void main(String[] args) {

//        Driver driver = null;
//        try {
//            driver = new FabricMySQLDriver();
//            DriverManager.registerDriver(driver);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//                System.out.println("PIZDOSIK");
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sys","root", "root");
//            System.out.println("111111");
//        } catch (SQLException e) {
//            System.out.println("ПИЗДЕЦ");
//        }

//        MysqlDataSource dataSource = new MysqlDataSource();
//        dataSource.setUser("root");
//        dataSource.setPassword("root");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/mydbtest?autoReconnect=true&useSSL=false");
//        try {
//            Connection conn = dataSource.getConnection();
//            System.out.println("111111");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        if (a == b) {
            System.out.println("true");
        }
        else System.out.println("false");
        new MainApp("Сервер");
//        new ListDevices();
        Server server = Server.getServer();
        Thread t = new Thread(server);
        t.start();



    }

}