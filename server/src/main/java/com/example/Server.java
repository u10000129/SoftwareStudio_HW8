package com.example;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

/**
 * Created by NTHUCS on 2016/6/12.
 */
public class Server implements Runnable{
    private Thread thread;
    private ServerSocket servSock;
    private JFrame parent;
    private JTextArea textArea;

    public Server(JFrame f){
        this.parent = f;
        this.textArea = new JTextArea();
        this.parent.add(this.textArea);
        try {
            // Detect server ip
            InetAddress IP = InetAddress.getLocalHost();
            System.out.println("IP of my system is := "+IP.getHostAddress());
            textArea.append("IP of my system is := "+IP.getHostAddress()+"\n");
            System.out.println("Waitting to connect......");
            textArea.append("Waitting to connect......\n");

            // Create server socket
            servSock = new ServerSocket(2000);

            // Create socket thread
            thread = new Thread(this);
            thread.start();
        } catch (java.io.IOException e) {
            System.out.println("Socket啟動有問題 !");
            System.out.println("IOException :" + e.toString());
        } finally{

        }
    }

    @Override
    public void run(){
        // Running for waitting multiple client
        while(true){
            try{
                // After client connected, create client socket connect with client
                Socket clntSock = servSock.accept();
                InputStream in = clntSock.getInputStream();

                System.out.println("Connected!!");
                this.textArea.append("Connected!!\n");

                // Transfer data
                byte[] b = new byte[1024];
                int length;

                length = in.read(b);
                String s = new String(b);
                System.out.println("[Server Said]" + s);
                this.textArea.append("The result from App is" + s+"\n");
            }
            catch(Exception e){
                //System.out.println("Error: "+e.getMessage());
            }
        }
    }
}
