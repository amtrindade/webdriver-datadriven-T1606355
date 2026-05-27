package com.core;

import static com.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;


public class BaseTest {
	

	@AfterMethod
	public void tearDown(ITestResult testResult) throws InterruptedException, IOException {
			
		String nameTest = testResult.getName()+"-"+ LocalDateTime.now();
		
		File screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("target" + File.separator + nameTest + ".jpg"));
	}
	
	@AfterTest
	public void tearDownAfter() {
		DriverFactory.killDriver();
	}

}
