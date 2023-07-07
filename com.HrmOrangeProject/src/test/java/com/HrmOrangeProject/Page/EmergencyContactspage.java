package com.HrmOrangeProject.Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HrmOrangeProject.BaseSetup.BaseSetup;

public class EmergencyContactspage extends ContactsPage {
	
	WebDriverWait wait;
	public EmergencyContactspage()
	{     
		this.driver=driver;	     
		 PageFactory.initElements(driver, this);		 
	}
	@FindBy(xpath="//span[text()='My Info']")
	WebElement myInfo;
	
	@FindBy(xpath="//a[text()='Emergency Contacts']")
	WebElement emergencyContacts;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--text'][1]")
	WebElement add_Btn;
	
	@FindBy(xpath="//label[text()='Name']/../..//input")
	WebElement name_field;
	
	@FindBy(xpath="//label[text()='Relationship']/../..//input")
	WebElement relationship_field;
	
	@FindBy(xpath="//label[text()='Home Telephone']/../..//input")
	WebElement home_telephone;
	
	@FindBy(xpath="//label[text()='Mobile']/../..//input")
	WebElement mobile_phone;
	
	@FindBy(xpath="//label[text()='Work Telephone']/../..//input")
	WebElement work_telephone;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save_btn;
	
	
	
	@FindBy(id="oxd-toaster_1")
	WebElement popup;
	
	@FindBy(xpath="class='oxd-topbar-header-breadcrumb'")
	WebElement dashBoard;
	
	@FindBy(xpath="//a[@class='oxd-brand']")
	WebElement orangeHrm;		
	
	@BeforeMethod
	public void loginSetup()
	{ 	
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\ChromeDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(homePageUrl);
	driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));	
  	PageFactory.initElements(driver, this);	
	uName.sendKeys("Admin");
	pwd.sendKeys("admin123");
	loginBtn.click();	
	System.out.println(driver.getCurrentUrl());
	
   }
		
		@Test
		public void test() throws InterruptedException
		{
			myInfo.click();
			emergencyContacts.click();
		    System.out.println(driver.getCurrentUrl());
		    add_Btn.click();
		    name_field.sendKeys(Keys.CONTROL+ "a" + Keys.DELETE);	    
		    name_field.sendKeys("nithya");
		    relationship_field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		    relationship_field .sendKeys("sister");
		    Thread.sleep(2000);
		    
		    Actions act=new Actions(driver);
		    act.moveToElement(home_phone).sendKeys("1111111111");
		   // home_phone.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);	
		  //  home_phone.sendKeys("1234567899");
		 //   mobile_phone.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);	 
		    mobile_phone.sendKeys("1234567899");
		  //  work_phone.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
		  //  work_phone.sendKeys("1234567899");
		    save_btn.click();
		    Thread.sleep(3000);
		    if(popup.isDisplayed())
		    {
		    	System.out.println(" true");		   
		    }
		    else
		    {
		    	System.out.println( "false");
		     }
		    
		    
		    
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
	}

