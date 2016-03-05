package com.example.myfirstapp.test;
/**
 * 封装业务场景方法的类
 * 可以根据业务场景来创建多个BussinessLib类，这样可以按照不同的业务场景来划分测试用例
 */

import android.app.Activity;
import android.app.Instrumentation;

import com.example.myfirstapp.lib.CommonLib;
import com.example.myfirstapp.lib.NewSolo;
import com.example.myfirstapp.lib.ObjectStore;

class BussinessLib extends NewSolo 
{
	public BussinessLib(Instrumentation instrumentation) 
    {
		super(instrumentation);
    }
	public BussinessLib(Instrumentation instrumentation, Activity activity) 
	{
		super(instrumentation, activity);
	}
    
	/**
	 * 登陆业务方法
	 */
    public void login()
    {
    	super.newTypeText(0,CommonLib.getPropertyString("username"));
    	super.newTypeText(1,CommonLib.getPropertyString("password"));
    	super.newClickOnButton(ObjectStore.SignIn_SignInOrRegister);
    }
    
    void login(String p_user,String p_password)
    {
    	super.newTypeText(0,p_user);
    	super.newTypeText(1,p_password);
    	super.newClickOnButton(ObjectStore.SignIn_SignInOrRegister);
    }
	
	

}
