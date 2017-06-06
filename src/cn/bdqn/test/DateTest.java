package cn.bdqn.test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {
	/**
	 * 日期格式 常用的两种
	 * yyyy-MM-dd
	 * yyyy/MM/dd
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		// 01.Date 转换成字符串
		Date date =new Date();
		System.out.println("01.转换前：------------>"+date);
		// 使用日期转换类
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// 把日期转换成字符串
		System.out.println("01.转换后：------------>"+format.format(date));
		
		// 02.字符串 转换成 Date
		String str="2016-11-12 03:58:32";
		date=format.parse(str);
		System.out.println("02.------------>"+date);
	}
	
	//03.把 sql Date 转换成 util Date
	@Test
	public void test01(){
		Date date=new Date(); //java.util System.out.println(date.getYear()+1900);
		//java.sql.Date(date) 需要我们传递一个long类型的参数
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		System.out.println(sqlDate);
		System.out.println(sqlDate.getYear());
	}
	
	//04.把 字符串 转换成 TimeStamp类型（时间戳）
	@Test
	public void test02(){
		// 需要一个long类型的参数
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		System.out.println(ts); // 2016-11-12 16:11:27.828
		String str="2015-09-01 01:01:01";
		
		/*
		 * valueOf（字符串的类型必须是 底层规定的）
		 * 
		 * 底层代码：[] 代表 可有可无
		 * 
		 * String formatError = "Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]";
		 */
		ts=ts.valueOf(str);
		System.out.println(ts);
	}
	
	//04.把TimeStamp类型 转换成 字符串
	@Test
	public void test03(){
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		//01.方式 最简单
		System.out.println(ts.toString());
		//02.SimpleDateFormat
		DateFormat format=new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		System.out.println(format.format(ts));
	}
	
	/*
	 * 05.把  TimeStamp类型 转换成 util.Date
	 * 
	 * 底层代码发现 TimeStamp 是Date的 子类
	 * public class Timestamp extends java.util.Date
	 */
	@Test
	public void test04(){
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=new Date();
		System.out.println("date====>"+date);
		date=ts;//转换
		System.out.println("ts====>"+date);
	}
	
	//06.util.Date 不能直接转 换成 TimeStamp类型 需要借助String
	@Test
	public void test05(){
		Timestamp ts=new Timestamp(System.currentTimeMillis());
		Date date=new Date();
		System.out.println("date====>"+date);
		if (ts instanceof Date) {
			ts=(Timestamp) date;
		}
		System.out.println("ts====>"+ts);
	}
	
	
	
	
}
