package com.example.myfirstapp.test;

import org.junit.Test;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import com.example.myfirstapp.lib.CommonLib;
import com.example.myfirstapp.lib.InputDataStore;
import com.example.myfirstapp.lib.NewSolo;
import com.example.myfirstapp.lib.NewTakeshot;
import com.example.myfirstapp.lib.ObjectStore;
import com.example.myfirstapp.lib.VPDataStore;
import com.robotium.solo.Solo;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class Login extends ActivityInstrumentationTestCase2
{
	private static final String TAG = "Kevin";
	private BussinessLib business;
	
	//构造函数
	public Login() throws ClassNotFoundException
	{
		super(Class.forName(InputDataStore.Input_MainActivity));//加载被测应用的MainActivity
		Log.i(TAG,"init");
	}
	
	@Override
	protected void setUp() throws Exception 
	{
		if(business == null){
			business = new BussinessLib(getInstrumentation(),getActivity());
			business.newSetup("testreport");//不能是非英文的，要不ddms中导不出来
		}
	}
	
	//测试case
	@Test
	public void test1() throws Exception
	{
		//这里我们写的测试脚本
		String caseName = "case1-----验证登录";
		//登陆业务
		business.login();
		//校验登陆业务
		business.newVerifyEquals(caseName,business.waitForText(VPDataStore.VP_MyfirstApp_Send, 1,
				InputDataStore.Input_ObjectWaitTime), true);
		
		
		caseName="Case2---验证输入显示是否成功";
		business.newTypeText(0, InputDataStore.Input_MyFirstApp_TextField_0);
		business.newClickOnButton(ObjectStore.MyfirstApp_Send);
		business.newVerifyEquals(caseName,business.waitForText(
				VPDataStore.VP_MyFirstApp_TextField_0, 1, InputDataStore.Input_ObjectWaitTime), true);
		
		caseName="Case3---########";
		
	}
	
	
	@Override
	protected void tearDown() throws Exception 
	{
		business.newTeardown();
	}
	
}

