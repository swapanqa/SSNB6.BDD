package com.shiftedtech.framework;

import org.apache.commons.compress.archivers.zip.ScatterStatistics;

import com.shiftedtech.pages.HomePage;
import com.shiftedtech.pages.LoginPage;

public class PageFactory {
	
	private static PageFactory instance = null;
	private HomePage homePage;
	private LoginPage loginPage;
	
	private PageFactory() {
		homePage = new HomePage();
		loginPage = new LoginPage();
	}
	
	public static PageFactory getInstance() {
		if(instance == null) {
			instance = new PageFactory();
		}
		return instance;
	}
	
	public HomePage homePage() {
		return homePage;
	}
	
	public LoginPage loginPage() {
		return loginPage;
	}

}
