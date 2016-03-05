package com.example.myfirstapp.test;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * 用来批量执行多个case
 * @author Administrator
 *
 */
public class SuitCase
{
	
	public static void main(String[] args)
	{
		junit.textui.TestRunner.run(suite());
	}
	
	public static Test suite()
	{
		TestSuite suite = new TestSuite();
		suite.addTestSuite(Login.class);
		//如果是case与suite类不是同一个包下的，case前加上包名
		//suite.addTestSuite(Case1.class);
		//suite.addTestSuite(Case2.class);
		return suite;
	}
}
