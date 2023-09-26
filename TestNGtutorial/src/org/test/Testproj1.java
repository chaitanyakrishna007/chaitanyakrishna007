package org.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testproj1 {
	
	@Test
	public void demo() {
		
		System.out.println("Hello Test");

	}
	@BeforeMethod
	
	public void beMethods() {
		
		System.out.println("I am executing before methods in testproj1 class");
		
	}
	@Test(groups= {"SMOKE"})
	public void demo1() {
		System.out.println("Bye Test");
	}
	@AfterMethod
	public void afMethods() {
		
		System.out.println("I am executing after methods in testproj1 class");
	}
	
	@BeforeClass
	public void beClass() {
		System.out.println("I am executing before class");
	}
}
