/**
 * 封装Solo类的原生方法
 */
package com.example.myfirstapp.lib;

import com.robotium.solo.Solo;
import android.app.Activity;
import android.app.Instrumentation;
import android.util.Log;

public class NewSolo extends Solo
{
	//logcat的标签
	public static  String tag="Kevin";
	//等待元素出现的时间
	private int ObjectWaitTime=Integer.parseInt(CommonLib.getPropertyString("objectWaitTime"));	
	//各个solo的方法执行的等待间隔时间
	private int APIWaitTime=Integer.parseInt(CommonLib.getPropertyString("APIWaitTime"));		
	
	ReportLib rl = new ReportLib();
	
	//构造函数重载
	public NewSolo(Instrumentation instrumentation) 
	{
		super(instrumentation);	
	}
	public NewSolo(Instrumentation instrumentation, Activity activity) 
	{
		super(instrumentation, activity);
	}
	
	/**
	 * 重写点击按钮的方法
	 * @param p_Text
	 */
	public void newClickOnButton(String p_Text)
	{
		//if(super.getCurrentActivity()==null)
		try{
			sleep(APIWaitTime);	
			if(super.waitForText(p_Text, 1, ObjectWaitTime))
			{
				super.clickOnButton(p_Text);
				Log.i(tag, DebugInfoStore.Info_Click+ DebugInfoStore.Info_Button+ p_Text +DebugInfoStore.Info_Pass);
			}
			else 
			{
				Log.e(tag, DebugInfoStore.Info_Click+ DebugInfoStore.Info_Button+ p_Text +DebugInfoStore.Info_Fail);
			}
		}catch (Exception e)
		{
			 Log.e(tag,  DebugInfoStore.Info_Click+ DebugInfoStore.Info_Button+ p_Text +DebugInfoStore.Info_Exception);
		}
	}
    
	/**
	 * 重写输入文本的方法
	 * @param p_index
	 * @param p_Text
	 */
	public void newTypeText(int p_index,String p_Text)
	{
		try{
			sleep(APIWaitTime);
			super.clearEditText(p_index);
			super.typeText(p_index,p_Text);
			Log.i(tag, "Type Text"+p_Text+ "Success!");
		}catch (Exception e)
		{
			Log.e(tag, "Type Text"+p_Text+ "Exception");
		}
	}
	
	/**
	 * 重写点击手机的Menu菜单的方法
	 * @param p_Text
	 */
	public void newClickOnMenuItem(String p_Text)
	{
		try{
		  sleep(APIWaitTime);
		  super.clickOnMenuItem(p_Text);
		  Log.i(tag, "click on menu"+p_Text+ "Success!");
		}catch (Exception e)
		{
	      Log.e(tag, "click on menu"+p_Text+ "Exception");
		}
	}
	
	/**
	 * 重写返回的方法
	 */
	public void newGoBack()
	{
		try{
		  sleep(APIWaitTime);	
		  super.goBack();
		  Log.i(tag, "goBack "+"Success!");
		}catch (Exception e)
		{
			Log.e(tag, "goBack "+ "Exception");
		}
	}
	
	/**
	 * 重写点击home键的方法
	 */
   public void newClickOnActionBarHomeButton()
	{
		try{
		  sleep(APIWaitTime);
		  super.clickOnActionBarHomeButton();
		  Log.i(tag, "Click Home button"+ "Success!");
		}catch (Exception e)
		{
		  Log.e(tag, "Click Home button"+ "Exception");
		}
	}
   
   /**
    * 重写junit的断言方法
    * @param p_message
    * @param p_expected
    * @param p_actual
    * @throws Exception
    */
   public void newVerifyEquals(String p_message, Object p_expected,Object p_actual) throws Exception 
   {
	   String shotImage=CommonLib.getCurrentTime()+".jpg";
		if (p_expected== p_actual) 
		{
			ReportLib.logWriter(p_message, p_expected, p_actual, "Pass");
			Log.i(tag,p_message + DebugInfoStore.Info_Pass);
		} 
		else 
		{
			ReportLib.setImageName(shotImage);
			NewTakeshot.shoot(getCurrentActivity(), InputDataStore.Input_LogImagePath+shotImage);
			ReportLib.logWriter(p_message, p_expected, p_actual, "Fail");
			Log.e(tag,p_message +DebugInfoStore.Info_Fail + "expected=" + p_expected + " actual=" + p_actual);
		}
	}
   
   /**
    * 重写junit的setup方法
    * @param p_Name
    */
   public void newSetup(String p_Name)
   {
	   String reportName=p_Name+"_"+CommonLib.getCurrentTime()+".html";
		try{
			Thread.sleep(APIWaitTime);
		  if (rl.setup(reportName))
		     Log.i(tag, DebugInfoStore.Info_Setup+DebugInfoStore.Info_Pass);
		  else {
			 Log.e(tag,  DebugInfoStore.Info_Setup+DebugInfoStore.Info_Fail);
		  }
		}catch (Exception e)
		{
			 Log.e(tag, DebugInfoStore.Info_Setup+DebugInfoStore.Info_Exception);
		}
  	}
   
   /**
    * 重写junit的teardown方法
    */
   public void newTeardown()
   {
	   try{
			 super.finishOpenedActivities();
			 rl.closeLog();
			 Log.i(tag,DebugInfoStore.Info_Teardown+DebugInfoStore.Info_Pass);
		  }catch (Exception e)
		  {
			 rl.closeLog();		
			 Log.e(tag, DebugInfoStore.Info_Teardown+DebugInfoStore.Info_Exception);
	   }
   }
	
   
}
   
   
  