package com.modusbps.bos.selenium;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.modusbps.selenium.CRMWebScraper;

public class CRMWebScraperTestCase {
	private CRMWebScraper webscraper;
	
	private static final String LOGIN_URL = "http://demo.fatfreecrm.com/login";
	
	private static final String USERNAME = "aaron";
	private static final String PASSWORD = "aaron";


	@Before
	public void setUp() throws Exception {
		webscraper = new CRMWebScraper(LOGIN_URL);
	}
	
	@Test
	public void testOpenSite() throws Exception {
		webscraper.openSite();
		webscraper.login(USERNAME, PASSWORD);
		webscraper.getText();
	}

//	@Test
//	public void testLogin() {
//		webscraper.login(USERNAME, PASSWORD);
//	}
//
//	@Test
//	public void testGetText() throws Exception {
//		webscraper.getText();
//	}

	@After
	public void tearDown() throws Exception {
		webscraper = null;
	}

}
