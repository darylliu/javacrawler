package com.db;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.model.Item;

public class MYSQLControl {
	//根据自己的数据库地址修改
  static DataSource ds = MyDataSource.getDataSource("jdbc:mysql://127.0.0.1:3306/NimrodHome?characterEncoding=utf8");
  static QueryRunner qr = new QueryRunner(ds);
  //第一类方法
  public static void executeUpdate(String sql){
      try {
          qr.update(sql);
      } catch (SQLException e) {
          e.printStackTrace();
      }
  }
  //第二类数据库操作方法
  public static void executeInsert(List<Item> data) throws SQLException {
      /*
       * 定义一个Object数组，行列
       * 3表示列数，根据自己的数据定义这里面的数字
       * params[i][0]等是对数组赋值，这里用到集合的get方法
       * 
       */
      Object[][] params = new Object[data.size()][11];
      for ( int i=0; i<params.length; i++ ){
          params[i][0] = data.get(i).getItemId();
          params[i][1] = data.get(i).getTitle();
          params[i][2] = data.get(i).getSales();
          params[i][3] = data.get(i).getPrice();
          params[i][4] = data.get(i).getType1();
          params[i][5] = data.get(i).getType2();
          params[i][6] = data.get(i).getType3();
          params[i][7] = data.get(i).getType4();
          params[i][8] = data.get(i).getType5();
          params[i][9] = data.get(i).getUrl();
          params[i][10] = data.get(i).getImg();
      }
      qr.batch("insert into qijia (item_id, title, sales, price, type1, type2, type3, type4, type5, url, img)"
              + "values (?,?,?,?,?,?,?,?,?,?,?)", params);
      System.out.println("执行数据库完毕！"+"成功插入数据："+data.size()+"条");

  }
}
