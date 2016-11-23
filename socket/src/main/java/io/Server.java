package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by A-mdx on 2016/11/22.
 */
public class Server {

    public static void main(String[] args) {
        try {
            // build
            ServerSocket serverSocket = new ServerSocket(8088);
            // accept等待中
            Socket socket = serverSocket.accept();
            // 接收后用socket通信
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = br.readLine();
            System.out.println("received from client : "+line);
            // 发数据去
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            pw.println("ok ,I am received data... -> "+line);
            pw.flush();
            
            pw.close();
            br.close();
            socket.close();
            serverSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    
}
