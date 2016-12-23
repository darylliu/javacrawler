package com.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ImgDownload {
	public static boolean getImageFromWeb(String urlString, String imgName, String path){
		URL url;  
    try {  
        url = new URL(urlString);  
//        System.out.println(urlString);
         // 打开URL连接  
        URLConnection con = (URLConnection)url.openConnection();  
         // 得到URL的输入流  
        InputStream input = con.getInputStream();  
        // 设置数据缓冲  
        byte[] bs = new byte[1024 * 2];  
        // 读取到的数据长度  
        int len;  
        // 输出的文件流保存图片至本地  
        if(imgName.equals("")){
        	imgName = (int)(1+Math.random()*1000)+".jpg";
        }
//        System.out.println(imgName);
        File dir = new File(path);
        if(!dir.exists() &&!dir.isDirectory()){
        	dir.mkdir();
        }
        File file = new File(path+imgName);
        if(!file.exists()){
        	file.createNewFile();
        }
//        System.out.println(path+imgName);
        OutputStream os = new FileOutputStream(file);  
        while ((len = input.read(bs)) != -1) {  
        os.write(bs, 0, len);  
        }  
        os.close();  
        input.close();  
        return true;
    } catch (MalformedURLException e) {  
        // TODO 自动生成的 catch 块  
        e.printStackTrace();  
    } catch (IOException e) {  
        // TODO 自动生成的 catch 块  
        e.printStackTrace();  
    }
    return false;
	}
}
