package demo_1;

import java.io.*;

// 将一个文件夹中的内容复制到其它目录中。（比如:把D:\\chenhao中的内容复制一份到 e:\\zhangsan文件夹中）
//递归和通过字节流来进行复制FileInputStream和FileOutputStream
public class FileCopy {
    public static void main(String[] args) {
        //被拷贝的文件路径
        File src = new File("C:/Users/Hanabi/Desktop/职坐标-大数据开发");
        //拷贝出来的文件存放的路径
        File des = new File("C:/Users/Hanabi/Desktop/test"+File.separator+ src.getName());
        //调用拷贝方法
        CopyUtil copyUtil = new CopyUtil();
        copyUtil.copyAll(src,des);
    }
}

class CopyUtil{
    //连同文件夹可以一起复制
    public void copyAll(File src, File des){
        //判断需要存放的文件是否存在
        if (!des.exists()){
            des.mkdir();
        }
        //
        if (src != null){
            File[] files = src.listFiles();
            for (File file : files) {
                if (file.isDirectory()){//文件夹继续打开
                    copyAll(file,new File(des.getAbsoluteFile() + "/" + file.getName()));
                }else {//文件则进行复制
                    copy(file,new File(des.getAbsoluteFile() + "/" + file.getName()));
                }
            }
        }
    }


    //复制一个文件的操作
    public void copy(File src, File des) {
        try {
            //和源文件建立输入流管道
            FileInputStream fis = new FileInputStream(src);
            //和目标文件建立输出流管道
            FileOutputStream fos = new FileOutputStream(des);
            //拷贝
            int len = -1;
            byte[] buffer = new byte[1024 * 1024];//创建 1MB 大小的缓冲区
            while ((len = fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
            //关闭管道，释放资源
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}