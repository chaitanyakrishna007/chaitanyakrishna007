package org.test;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testproj5 {
	
	@Test(dependsOnMethods = {"demo7"})
	
	public void demo6() {
		System.out.println("College 6 loggedin");
		
	}
	@Test(groups= {"SMOKE"})
	
	public void demo7() {
		
		System.out.println("College 7 loggedin");
		
	}
	
	@Test(enabled=false)
	public void demo8() {
		System.out.println("College 8 loggedin");
		
	}
	
	@Test(timeOut=4000)
	public void demo9() {
		System.out.println("College 9 loggedin");
		
	}
	@Parameters({"URL"})
	@Test
	public void demo10(String urlName) {
		System.out.println("College 10 loggedin");
		System.out.println(urlName);
		
	}
	@Test@Parameters({"URL"})
	public void demo11(String uName) {
		System.out.println("College 11 loggedin");
		System.out.println(uName);
	}
}
