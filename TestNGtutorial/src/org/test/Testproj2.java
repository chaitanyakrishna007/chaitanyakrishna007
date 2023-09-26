package org.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testproj2 {
	
@Test(groups= {"SMOKE"})
public void test2() {
	System.out.println("Test2");
}

@BeforeClass
public void bfClass() {
	System.out.println("Iam Executing before class in testproj2 class");
}

}
