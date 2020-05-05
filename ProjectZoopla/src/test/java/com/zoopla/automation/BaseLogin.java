package com.zoopla.automation;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class BaseLogin {
	
	public static void main(String[] args) throws IOException {
		File src;
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true");
		Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;  // Type casting polymorphism change the interface into driver
		driver.manage().window().maximize();
		driver.get("https://www.zoopla.co.uk/");
	//	System.out.println(driver.getTitle());
		
		WebElement acceptCookie = driver.findElement(By.xpath("//button[@class='ui-button-primary ui-cookie-accept-all-medium-large']"));
		acceptCookie.click();
		
		WebElement signInLink = driver.findElement(By.xpath("//a[@class='button button--tertiary-dark account-link__text']"));
		js.executeScript("arguments[0].setAttribute('style','background:blue; border:2px solid red;');",signInLink);
		src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./ScreenShots/ClickSignLink.jpg"));
		signInLink.click();
		
		WebElement userName = driver.findElement(By.xpath("//input[@id='signin_email']"));
		userName.sendKeys("ziahassan@hotmail.com");
		js.executeScript("arguments[0].setAttribute('style','background:blue; border:2px solid red;');",userName);
		
		WebElement passWord = driver.findElement(By.xpath("//input[@id='signin_password']"));
		passWord.sendKeys("smarttech");
		js.executeScript("arguments[0].setAttribute('style','background:blue; border:2px solid red;');",passWord);
		src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./ScreenShots/SignIn.jpg"));
		
		WebElement signInBtn = driver.findElement(By.xpath("//button[@id='signin_submit']"));
		js.executeScript("arguments[0].setAttribute('style','background:blue; border:2px solid red;');",signInBtn);
		src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("./ScreenShots/SignIn.jpg"));
		signInBtn.click();
		System.out.println("Title of the Page is: "+driver.getTitle());
		
	}
	

}
