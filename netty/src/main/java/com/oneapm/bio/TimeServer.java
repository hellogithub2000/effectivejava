package com.oneapm.bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * used to
 * Created by tianjin on 10/13/16.
 */
public class TimeServer {
    public static void main(String[] args) throws IOException {
        int port = 8080;
        if(args != null && args.length > 0){
            port = Integer.valueOf(args[0]);
        }

        ServerSocket server = null;
        try {
            server = new ServerSocket(port);
            System.out.println("The time server is start in port :" + port);
            Socket socket = null;
            while (true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } finally {
            if(server != null){
                System.out.println("The time sever close");
                server.close();
                server = null;
            }
        }
    }
}
