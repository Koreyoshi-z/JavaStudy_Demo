package demo_2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//获取一个文件夹下所有指定后缀名(.java)的文件（包括子文件夹中的内容），并将这些文件的绝对路径写入到一个文本文件中
public class FileSearch {
    public static void main(String[] args) {
        //需要获取的文件夹路径
        String folderPath = "D:/JavaStudyCode";
        //文件扩展名
        String fileExtension = ".java";
        //存放路径的文本
        String outputFilePath = "D:/JavaStudy/java_files.txt";

        List<String> filePaths = new ArrayList<>();//存放路径名的容器

        //调用方法
        findFiles(folderPath,fileExtension,filePaths);
        writeToFile(outputFilePath,filePaths);

    }

    //在指定文件夹下查找符合要求文件名后缀的文件
    private static void findFiles(String folderPath,String fileExtension,List<String> filePaths){
        File folder = new File(folderPath);
        File[] files = folder.listFiles();
        if (files!=null){
            for (File file : files) {
                //是文件夹就继续打开
                if (file.isDirectory()){
                    findFiles(file.getAbsolutePath(),fileExtension,filePaths);
                }
                //将匹配的文件路径名进行添加到容器中
                if (file.getName().endsWith(fileExtension)){
                    filePaths.add(file.getAbsolutePath());
                }
            }
        }
    }

    //将容器中的数据添加在指定文件中
    private static void writeToFile(String outputFilePath,List<String> filePaths){
        try {
            FileWriter writer = new FileWriter(outputFilePath);
            for (String filePath : filePaths) {
                writer.write(filePath+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
