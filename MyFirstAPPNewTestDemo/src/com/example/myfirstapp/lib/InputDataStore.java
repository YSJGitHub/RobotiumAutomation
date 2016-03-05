package com.example.myfirstapp.lib;
/***
 * 封装输入的信息,以及package信息
 * @author Administrator
 *
 */
public class InputDataStore 
{
	//被测应用的Mainactivity
	public static String Input_TargetPakage="com.example.myfirstapp";
	public static String Input_MainActivity=Input_TargetPakage+".LoginActivity";
	
	public static int Input_ObjectWaitTime=Integer.parseInt( CommonLib.getPropertyString("objectWaitTime"));
	public static int Input_APIWaitTime=Integer.parseInt( CommonLib.getPropertyString("APIWaitTime"));
	
	public static String Input_TargetTestPakage=Input_TargetPakage+".test";
	public static String Input_LogPath="/data/data/"+Input_TargetTestPakage+"/Result/";
	public static String Input_LogImagePath="/data/data/"+Input_TargetPakage+".test"+"/Result/Image/";
	
	public static String Input_MyFirstApp_TextField_0="Hello";
}
