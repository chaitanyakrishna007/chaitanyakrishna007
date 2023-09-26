package org.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Testproj3 {
	
	@Test
	
	public void demo3() {
		System.out.println("student 3 loggedin");
		
	}
	@Test(dataProvider = "getData")
	
	public void demo4(String userName,String pwd) {
		
		System.out.println("student 4 loggedin");
		System.out.println(userName);
		System.out.println(pwd);
	}
	
	@Test
	public void demo5() {
		System.out.println("student 5 loggedin");
		
	}
	@DataProvider
	
	public Object[][] getData() {
		Object[][] data = new Object[3][2];
		
		data[0][0]= "FirstUser";
		data[0][1]= "FirstPwd";
		
		data[1][0]= "SecondUser";
		data[1][1]= "SecondPwd";
		
		data[2][0]= "ThirdUser";
		data[2][1]= "ThirdPwd";
		
		return data;
		
		
	}
}
