package com.parse;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.constant.Constant;
import com.model.Item;
import com.util.ImgDownload;

public class Parser {
	public static Item getData (String html) throws Exception{
    //获取的数据，存放在集合中
    Item item = new Item();
    //采用Jsoup解析
    Document doc = Jsoup.parse(html);
    //获取html标签中的内容
//    Elements elements = doc.select("div[class=sale-item-detail]");
    String title = doc.select("div[class=sale-item-title]").select("h1").text();
    if(!title.contains("套"))
    	return null;
    String price = doc.select("span[class=sale-price]").select("strong").select("span").text();
    item.setTitle(title);
  	item.setPrice(price);
    String itemId = doc.getElementById("item_id").val();
    item.setItemId(itemId);
//    String record = doc.getElementById("evaluation").text();
//    item.setSales(record.substring(1, record.length()-1));
    Elements types = doc.select("div[class=crumb]").select("a");
    for(int i=0; i<types.size(); i++){
    	item.setType1(types.get(1).text());
    	item.setType2(types.get(3).text());
    	item.setType3(types.get(4).text());
    	item.setType4(types.get(5).text());
    	item.setType5(types.get(6).text());
    }
    
    Elements imgs = doc.select("img[class=lazy]");
    for(Element img: imgs){
    	ImgDownload.getImageFromWeb(img.attr("data-original"), img.attr("title"), Constant.PATH + itemId +"/");
    }
    
    //返回数据
    return item;
}
	
}
