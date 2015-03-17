package com.fc.framework.test;

import com.fc.framework.web.util.MD5Util;

import junit.framework.TestCase;
import junit.framework.TestResult;

public class test1 extends TestCase {

	public void test01(){
		String str = MD5Util.encoder("123");
		System.out.println(str);
	}
}
