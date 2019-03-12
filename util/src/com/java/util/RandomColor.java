package com.java.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * 随机颜色生成
 * @auther xupeng
 * 2019.3.12
 */
public class RandomColor {

    public static void main(String[] args) throws IOException {
        //随机数的定义
        Random random = new Random();
        //生成redRandom
        int red = random.nextInt(256);
        //生成greenRandom
        int green = random.nextInt(256);
        //生成blueRandom
        int blue = random.nextInt(256);
        System.out.println("R:" + red + ",G:" + green + ",B:" + blue);

        //开始使用随机颜色绘制图片
        //1 先生成缓冲区生成一个图片对象
        Color color = new Color(red, green, blue);
        BufferedImage bufferedImage = new BufferedImage(140, 60, BufferedImage.TYPE_INT_RGB);
        //获取画笔
        Graphics g = bufferedImage.getGraphics();
        //设置一个字体
        Font font = new Font("微软雅黑", Font.BOLD, 30);
        g.setFont(font);
        //设置画笔颜色,使用随机的颜色
        //g.setColor(color);   背景色地方不随机，以白色为准
        //开始绘制,充满绘制矩形，充满缓冲区
        g.fillRect(0, 0, 140, 60);

        //设置随机数
        String codeNum = "";
        int[] code = new int[3];
        for (int i = 0; i < 4; i++) {
            int num = random.nextInt(10) + 48;
            int uppercase = random.nextInt(26) + 65;
            int lowercase = random.nextInt(26) + 97;
            code[0] = num;
            code[1] = uppercase;
            code[2] = lowercase;
            codeNum += (char) code[random.nextInt(3)];
        }
        //控制台验证输出的随机数
        System.out.println(codeNum);

        //绘制文字
        g.setColor(color.BLACK);
        g.drawString(codeNum, 35, 38);
        // 画干扰线
        for (int i = 0; i < 35; i++) {
            //设置线的颜色
            g.setColor(new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)));
            //画线
            g.drawLine(
                    random.nextInt(120),
                    random.nextInt(60),
                    random.nextInt(120),
                    random.nextInt(60));
        }
        //最后面的输出
        //指定文件路径
        File file = new File("D:/code.jpg");
        //获取字节输出流
        OutputStream outputStream = new FileOutputStream(file);
        //将图片从缓冲区通过字节流
        ImageIO.write(bufferedImage, "jpg", outputStream);
        //关闭输出流
        outputStream.close();
    }
}
