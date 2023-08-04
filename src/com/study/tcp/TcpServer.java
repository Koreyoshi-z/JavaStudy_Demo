package com.study.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//TCP服务端(需要先运行服务端，然后再运行客户端)
public class TcpServer {
    public static void main(String[] args) throws Exception {
        //1.创建一个ServerSocket对象
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("我是服务端");
        //2.调用accept方法来接受客户端的请求
        Socket socket = serverSocket.accept();
        //3.获取socket对象的输入输出流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //服务端负责把接受到的客户端信息转换成大写返回回去
        String line = null;
        while ((line= br.readLine())!=null){
            if (line.equals("over")){
                break;
            }
            System.out.println(line);
            bw.write(line.toUpperCase());//转换成大写
            bw.newLine();
            bw.flush();
        }
        bw.close();
        br.close();
        socket.close();
    }
}
