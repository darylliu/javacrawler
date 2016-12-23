package com.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;

import com.model.Item;
import com.parse.Parser;

public class URLFecter {
	public static Item URLParser (HttpClient client, String url, int i) throws Exception {
    //用来接收解析的数据
    Item data = null;
    //获取网站响应的html，这里调用了HTTPUtils类
    HttpResponse response = HTTPUtils.getRawHtml(client, url + i +"/");      
    //获取响应状态码
    int StatusCode = response.getStatusLine().getStatusCode();
    //如果状态响应码为200，则获取html实体内容或者json文件
    if(StatusCode == 200){
        String entity = EntityUtils.toString (response.getEntity(),"utf-8");    
        data = Parser.getData(entity);
//        System.out.println(data);
        if(data==null)
        	return data;
        data.setUrl(url + i +"/");
        EntityUtils.consume(response.getEntity());
    }else {
        //否则，消耗掉实体
        EntityUtils.consume(response.getEntity());
        return null;
    }
  //获取网站响应的html，这里调用了HTTPUtils类
    HttpResponse responseCount = HTTPUtils.getRawHtml(client, url + "get_90days_order_count?item_id="+i);      
    //获取响应状态码
    int StatusCodeCount = responseCount.getStatusLine().getStatusCode();
    //如果状态响应码为200，则获取html实体内容或者json文件
    if(StatusCodeCount == 200){
        String entity = EntityUtils.toString (responseCount.getEntity(),"utf-8");   
//        System.out.println(i+ "  sales: "+entity);
        data.setSales(entity);;
        EntityUtils.consume(responseCount.getEntity());
    }else {
        //否则，消耗掉实体
        EntityUtils.consume(responseCount.getEntity());
    }
//    System.out.println(StatusCode);
    return data;
}
}
