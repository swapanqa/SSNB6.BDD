package com.selenium.advance.test.rorobtApi.autoIT;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class UploadFileWithAutoIT {
	
	WebDriver driver;
	
	@Before
	public void Setup() {
	
		ChromeDriverManager.getInstance().arch32().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void test1() throws InterruptedException {
		driver.navigate().to("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@id='imagesrc']")).click();
		
		Thread.sleep(3000);
		
		try {
			Runtime.getRuntime().exec("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\AutoITScript\\fileupload.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
		

}
