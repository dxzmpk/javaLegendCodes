package com.company.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketTest {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(6013);
        while (true) {
            Socket client = socket.accept();
            PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
            /* write the Date to the socket */
            pout.println(new java.util.Date().toString());
            /* close the socket and resume */
            /* listening for connections */
            client.close();
        }


    }
}
