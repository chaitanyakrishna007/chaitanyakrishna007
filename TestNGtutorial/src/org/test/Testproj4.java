package org.test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testproj4 {
	
	@Test
	
	public void demo3() {
		System.out.println("College 1 loggedin");
		
	}
	@Test(groups= {"SMOKE"})
	
	public void demo4() {
		
		System.out.println("College 2 loggedin");
		
	}
	
	@BeforeTest
	public void demo5() {
		System.out.println("College 3 loggedin--before test");
		
	}
}
