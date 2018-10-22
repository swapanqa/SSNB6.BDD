package com.selenium.advance.test.rorobtApi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BrokenLinkTest {
	
	WebDriver driver;
	
	@Before
	public void Setup() {
	
		ChromeDriverManager.getInstance().arch32().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
	}
	
	@Test
	public void brokenLinkTest() {
		driver.navigate().to("http://spree.shiftedtech.com/");
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total Links: " + links.size());
		
		for(int i = 0; i < links.size(); i++) {
			WebElement element = links.get(i);
			String url = element.getAttribute("href");
			//System.out.println(url);
			try {
				varifyLinks(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void varifyLinks(String link) throws IOException {
		
		URL url = new URL(link);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setConnectTimeout(3000);
		httpURLConnection.connect();
		
		if(httpURLConnection.getResponseCode() == 200) {
			System.out.println(link + " - " + httpURLConnection.getResponseMessage());
		}
		
		if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
			System.out.println(link + " - " + httpURLConnection.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);

		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
