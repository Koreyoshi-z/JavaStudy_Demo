package com.study.tcp;

import java.io.*;
import java.net.Socket;

//TCP客户端
public class TcpClient {
    public static void main(String[] args) throws Exception {
        //1.创建一个Socket对象
        Socket socket = new Socket("127.0.1", 8888);
        //2.从Socket中获取I/O流
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //3.对I/O流进行读写操作，完成与服务端的交互。
        while (true){
            String line = br.readLine();//获取键盘输入的字符串
            bw.write(line);
            bw.newLine();
            bw.flush();
            if (line.equals("over")){
                break;
            }
            System.out.println(reader.readLine());//写回来大写的东西是不是在这里读出来
        }
        //4.关闭I/O流和Socket
        reader.close();
        bw.close();
        br.close();
        socket.close();

    }
}
