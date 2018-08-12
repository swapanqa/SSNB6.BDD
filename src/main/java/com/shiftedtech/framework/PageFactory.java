package com.shiftedtech.framework;

import org.apache.commons.compress.archivers.zip.ScatterStatistics;

import com.shiftedtech.pages.HomePage;
import com.shiftedtech.pages.LoginPage;

public class PageFactory {
	
	private static PageFactory instance = null;
	private HomePage homePage;
	private LoginPage loginPage;
	
	private PageFactory() {
	}
	
	public static PageFactory getInstance() {
		if(instance == null) {
			instance = new PageFactory();
		}
		return instance;
	}
	
	public void reset() {
		homePage = null;
		loginPage = null;
	}
	
	public HomePage homePage() {
		if(homePage == null) {
			homePage = new HomePage();
		}
		return homePage;
	}
	
	public LoginPage loginPage() {
		if(loginPage == null) {
			loginPage = new LoginPage();
		}
		return loginPage;
	}

}
