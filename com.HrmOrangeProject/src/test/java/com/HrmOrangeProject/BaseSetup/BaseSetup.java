package com.HrmOrangeProject.BaseSetup;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BaseSetup {  
	
	public WebDriver driver;
	final String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
//	LoginPage lp;
//	MyInfoPage myInfoPage;
	
	@BeforeMethod
	public void initialization()
	{
		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(homePageUrl);
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));	
	  //  lp=new LoginPage(driver);
	  
	    
	// /   myInfoPage=new MyInfoPage(driver);
	//    myInfoPage.myInfo_click();
	}
	@Test
	public void run()
	{
	 
	}

	
}
