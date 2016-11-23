package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by A-mdx on 2016/11/22.
 */
public class Client {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost",8080);
            PrintWriter pw = new PrintWriter(socket.getOutputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw.println("Hello,Mr.Server.");
            pw.flush();
            String line = br.readLine();
            System.out.println("ok,I am received from server: "+line);
            pw.close();
            br.close();
            socket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
