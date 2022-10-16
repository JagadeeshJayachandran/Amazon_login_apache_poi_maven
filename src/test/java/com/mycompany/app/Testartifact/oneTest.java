package com.mycompany.app.Testartifact;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class oneTest {
	
	@BeforeMethod
	public void BeforeTest()
	{
		System.out.println("Before Test");
	}
	@Parameters({"URL"})
	@Test
	public void testone(String url)
	{
		System.out.println("Testone" +url);
	}
	
	@Test
	public void testtwo()
	{
		System.out.println("Testtwo");
	}

}
