package com.study.example;

import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
public class HappyBirthday {
    public static void main(String[] args)
    {
        BufferedImage image = new BufferedImage(200, 50, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setFont(new Font("楷体", Font.BOLD, 30));
        g.drawString("生日快乐", 2, image.getHeight() - 20);
        int[] p = image.getRGB(0, 0, image.getWidth(), image.getHeight(), new int[image.getWidth() * image.getHeight()],
                0, image.getWidth());
        char[] cs = { '生', '日', '快', '乐' };
        int ics = 0;
        for (int i = 0; i < image.getHeight(); i++) {
            for (int j = 0; j < image.getWidth(); j++) {
                int off = i * image.getWidth() + j;
                if (p[off] != 0) {
                    System.out.print(cs[ics]);
                    ics = (ics + 1) % 4;
                } else {
                    System.out.print("　");
                }
                if (j == image.getWidth() - 1) {
                    System.out.println();
                }
            }
        }

    }
}


