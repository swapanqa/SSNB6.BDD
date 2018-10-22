package com.selenium.advance.test.rorobtApi;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.fasterxml.jackson.databind.Module.SetupContext;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class RobotApiUploadFile {

	WebDriver driver;
	
	@Before
	public void Setup() {
	
		ChromeDriverManager.getInstance().arch32().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	
	//@Test
	public void test1() throws AWTException {
		driver.navigate().to("http://demo.automationtesting.in/Register.html");
		driver.findElement(By.xpath("//input[@id='imagesrc']")).click();
		
		Robot robot = new Robot();
		
		robot.setAutoDelay(3000);
		
		StringSelection selection = new StringSelection("C:\\Users\\ShiftTeacher\\Pictures\\GitDiagram.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		robot.setAutoDelay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
			
	}
	

	public static void main(String[] args) throws AWTException {
		Robot robot = new Robot();
		
		int x = 100;
		int y = 100;
		int width = 200;
		int height = 200;
		
		Rectangle arRectangle = new Rectangle(x, y, width, height);
		BufferedImage bufferedImage = robot.createScreenCapture(arRectangle);
		
		robot.mouseWheel(-100);
		
		Color color = robot.getPixelColor(110, 80);
		
		System.out.println("Red: " + color.getRed());
		System.out.println("Green: " + color.getGreen());
		System.out.println("Blue: " + color.getBlue());

		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
