package com.example.myfirstapp.lib;

import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.MissingResourceException;
import java.util.Properties;
import android.util.Log;
/**
 * 与robotium无关的基础类
 * @author Administrator
 *
 */
public class CommonLib 
{
	/**
	 * 获取当前时间
	 * @return
	 */
	public static  String getCurrentTime() 
	{
	   try{
		   Calendar ca = Calendar.getInstance();
			int year = ca.get(Calendar.YEAR);
			int month = ca.get(Calendar.MONTH);
			int day = ca.get(Calendar.DATE);
			int minute = ca.get(Calendar.MINUTE);
			int hour = ca.get(Calendar.HOUR);
			int second = ca.get(Calendar.SECOND);
			String currentTime=(String.valueOf(year) + "-" + String.valueOf(month + 1) + "-"
					+ String.valueOf(day) + "-" + String.valueOf(hour) + "-"
					+ String.valueOf(minute) + "-" + String.valueOf(second));
			Log.i(NewSolo.tag,"The current time is: "+currentTime);
			return currentTime;
	   }
	   catch(Exception e){
		   Log.e(NewSolo.tag,"Exception: Get the current time "); 
		   return "00000000";
	   }
	}
/*	
   public static Properties getPropertyString() 
   {
	   Properties props = new Properties();  
       InputStream in = CommonLib.class.getResourceAsStream("/assets/Config.properties");  
       try {  
           props.load(in);  
           Log.i(NewSolo.tag,"Get file Config.properties "+"Success");
       } catch (IOException e) { 
    	   Log.e(NewSolo.tag,"Exception锛丟et file Config.properties ");
           e.printStackTrace();  
       }  
       return props;  
   }
 */
	/**
	 * 从配置文件中读取信息
	 * @param key
	 * @return
	 */
	public static String getPropertyString(String key ) 
	{
		InputStream in = CommonLib.class.getResourceAsStream("/assets/Config.properties");  
	    Properties properties = new Properties();
		try {
			properties.load(in);
			 Log.i(NewSolo.tag,"Get file Config.properties "+"Success");
		}
		catch (IOException e1) 
		{
			 Log.e(NewSolo.tag,"Exception: Get file Config.properties ");
		}
	        if (key == null || key.equals("") || key.equals("null")) 
	        {
	            return "";
	        }
	        String result = "";
	        try {
	            result = properties.getProperty(key); 
	        } 
	        catch (MissingResourceException e) 
	        {
	        	Log.e(NewSolo.tag,"Exception: Get file Config.properties ");
	        }
	        return result;
	}
	   
 }
