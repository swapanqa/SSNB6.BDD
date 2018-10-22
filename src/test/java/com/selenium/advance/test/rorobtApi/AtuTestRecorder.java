package com.selenium.advance.test.rorobtApi;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class AtuTestRecorder {
	
	WebDriver driver;
	
	@Before
	public void Setup() {
	
		ChromeDriverManager.getInstance().arch32().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void test1() throws FindFailed, ATUTestRecorderException {
		
		ATUTestRecorder recorder = new ATUTestRecorder("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\recordedVedio", "rec", false);
		recorder.start();
		
		Screen screen = new Screen();
		
		Pattern singinLink = new Pattern("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\screenshots\\signinLink.png");
		Pattern emailTextbox = new Pattern("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\screenshots\\emailTextBox.png");
		Pattern nextbutton = new Pattern("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\screenshots\\nextButton.png");
		Pattern passwordTextbox = new Pattern("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\screenshots\\passwordTextbox.png");
	
		driver.navigate().to("https://www.google.com/gmail/about/#");
		
		screen.wait(singinLink, 3);
		screen.click(singinLink);
		
		screen.wait(emailTextbox, 3);
		screen.type(emailTextbox, "email123@gmail.com");
		
		screen.wait(nextbutton, 1);
		screen.click(nextbutton);
		
		screen.wait(passwordTextbox, 2);
		screen.type("sdgfsdf");
		
		recorder.stop();
		
	}

}
