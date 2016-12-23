package com.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.constant.Constant;
import com.db.MYSQLControl;
import com.model.Item;
import com.util.URLFecter;

public class Main {

	
//	static final Log logger = LogFactory.getLog(Main.class);

	public static void main(String[] args) throws Exception {
		//初始化一个httpclient
    HttpClient client = new DefaultHttpClient();
    List<Item> datas = new ArrayList<Item>();
    //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
    String url= Constant.URL;
    for(int i=100101; i<=100500; i++){
    	//抓取的数据
      Item data=URLFecter.URLParser(client, url, i);
      System.out.println(i);
      if(i%10==0){
      	MYSQLControl.executeInsert(datas);
      	datas.clear();
      }
//      if(data==null){
//      	System.out.println("null");
//      }
      if(data!=null){
//      	System.out.println(data.toString());
      	datas.add(data);
      }
    }
    
    
//  	MYSQLControl.executeInsert(datas);

    
//    logger.info(data.toString());
    //循环输出抓取的数据
//    for (Item jd:bookdatas) {
//        logger.info("bookID:"+jd.getBookID()+"\t"+"bookPrice:"+jd.getBookPrice()+"\t"+"bookName:"+jd.getBookName());
//    }
    //将抓取的数据插入数据库
//    MYSQLControl.executeInsert(bookdatas);

	}

}
