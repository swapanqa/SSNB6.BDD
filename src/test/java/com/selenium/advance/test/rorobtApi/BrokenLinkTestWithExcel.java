package com.selenium.advance.test.rorobtApi;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.ChromeDriverManager;

public class BrokenLinkTestWithExcel {
	int i;

	WebDriver driver;
	
	@Before
	public void SetupContext() {
		ChromeDriverManager.getInstance().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
	}
	
    @Test
    public void brokenLinkTest(){
       
        driver.navigate().to("http://spree.shiftedtech.com/");

        List<WebElement> links=driver.findElements(By.tagName("a"));

        System.out.println("Total links are "+links.size());


        for(i=0;i<links.size();i++)
        {

            WebElement ele= links.get(i);

            String url=ele.getAttribute("href");

            try {
                verifyLinkActive(url);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            }

        }
    }

    public void verifyLinkActive(String linkUrl) throws IOException, EncryptedDocumentException, InvalidFormatException {

        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\resource\\links.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheet("status");
        sheet.createRow(0);
        sheet.getRow(0).createCell(0).setCellValue("Working Likns");

        try {
            URL url = new URL(linkUrl);

            HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();

            httpURLConnect.setConnectTimeout(3000);

            httpURLConnect.connect();

            if (httpURLConnect.getResponseCode() == 200) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
                sheet.createRow(i+2).createCell(0).setCellValue(linkUrl + " - " + httpURLConnect.getResponseMessage());

            }
            if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
                System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - " + HttpURLConnection.HTTP_NOT_FOUND);
                sheet.createRow(i+2).createCell(0).setCellValue(linkUrl + " - " + httpURLConnect.getResponseMessage());
            }


        } catch (Exception e) {

        }

        FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ShiftTeacher\\eclipse-workspace\\ssnb6.bdd\\resource\\links.xlsx");
        workbook.write(fileOutputStream);
        
       
    }


   @After
   public void teardown() {
	   driver.close();
	   driver.quit();
   }

}
