package com.modusbps.selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.thoughtworks.selenium.Selenium;

public class CRMWebScraper {
	
	private WebDriver driver;
	
	private String loginURL;
	@SuppressWarnings("deprecation")
	private Selenium selenium;
	
	public CRMWebScraper(String loginURL){
		this.loginURL = loginURL;
		
		System.setProperty("webdriver.chrome.driver", "c:\\temp\\chromedriver.exe");
		
		driver = new ChromeDriver();
	}
	
	public void openSite(){
		driver.navigate().to(loginURL);
	}
	
	
	/**
	 * 
	 * @param username
	 * @param Password
	 * 
	 *            Logins into the website, by entering provided username and
	 *            password
	 */
	public void login(String username, String Password) {

		WebElement userName_editbox = driver.findElement(By.id("authentication_username"));
		WebElement password_editbox = driver.findElement(By.id("authentication_password"));
		WebElement submit_button = driver.findElement(By.xpath("//input[@value='Login']"));

		userName_editbox.sendKeys(username);
		password_editbox.sendKeys(Password);
		submit_button.click();

	}

	/**
	 * grabs the status text and saves that into status.txt file
	 * 
	 * @throws IOException
	 */
	public void getText() throws IOException {
		System.out.println("Page Source:");
		System.out.println(driver.getPageSource());
		
		
//		String text = driver.findElement(By.xpath("//div[@id='case_login']/h3")).getText();
//		Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("status.txt"), "utf-8"));
//		writer.write(text);
//		writer.close();

	}

	/**
	 * Saves the screenshot
	 * 
	 * @throws IOException
	 */
	public void saveScreenshot() throws IOException {
		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("c:\\temp\\screenshot.png"));
	}

	public void closeBrowser() {
		driver.close();
	}
}
