package com.atguigu.spring5.testDemo;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

public class TestDoldImg {


    public static void main(String[] args) throws Exception {
        String url = "https://img.zcool.cn/community/01f9ea56e282836ac72531cbe0233b.jpg";
        Download1(url);
    }

    private static File Download(String urlList) throws Exception {

        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        File transFile;
        transFile = File.createTempFile(uuid, ".png");
        OutputStream outputStream=new FileOutputStream(transFile);


        String imageUrl = urlList;
        URL url = new URL(imageUrl);
        //打开网络输入流
        DataInputStream dis = new DataInputStream(url.openStream());
        String newImageName="D:/2.jpg";
        //建立一个新的文件
        FileOutputStream fos = new FileOutputStream(new File(newImageName));
        byte[] buffer = new byte[1024];
        int length;
        //开始填充数据
        while( (length = dis.read(buffer))>0){
            fos.write(buffer,0, length);
            outputStream.write(buffer,0, length);
        }
        dis.close();
        fos.close();
        outputStream.close();

        return transFile;


    }

    private static File Download1(String urlList) throws Exception {

        // 创建一个空file
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        File transFile;
        transFile = File.createTempFile(uuid, ".png");
        OutputStream outputStream=new FileOutputStream(transFile);

        String imageUrl = urlList;
        URL url = new URL(imageUrl);
        //打开网络输入流
        DataInputStream dis = new DataInputStream(url.openStream());
        byte[] buffer = new byte[2048];
        int length;
        //开始填充数据
        while( (length = dis.read(buffer))>0){
            outputStream.write(buffer,0, length);
        }
        dis.close();
        outputStream.close();
        return transFile;
    }




}
