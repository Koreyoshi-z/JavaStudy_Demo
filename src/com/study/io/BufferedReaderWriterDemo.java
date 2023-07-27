package com.study.io;

import java.io.*;

public class BufferedReaderWriterDemo {
    public static void main(String[] args) throws Exception {
        FileReader fr = new FileReader("D:\\JavaStudyCode\\JavaStudy_Demo\\src\\com\\study\\io\\FileReaderWriterDemo.java");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("C:\\Users\\Hanabi\\Desktop\\bbb.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        String line = null;//读取的行数
        while ((line=br.readLine()) != null){
            System.out.println(line);
            bw.write(line);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
