package com.HrmOrangeProject.Page;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.HrmOrangeProject.BaseSetup.BaseSetup;



public class ContactsPage {
	
	public WebDriver driver;
	final String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; 
	
	
	public ContactsPage()
	{
		this.driver=driver;	     
		  PageFactory.initElements(driver, this);		 	
	}
	
	@FindBy(id="welcome")
	WebElement welcomeUser;
 
	@FindBy(xpath="//input[@name='username' or @placeholder='username']")
	WebElement uName;
	
	@FindBy(xpath="//input[@placeholder='password' or @name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="class='oxd-topbar-header-breadcrumb'")
	WebElement dashBoard;
	
	@FindBy(xpath="//a[@class='oxd-brand']")
	WebElement orangeHrm;	
	
	@FindBy(xpath="//span[text()='My Info']")
	WebElement myInfo;
	
	@FindBy(xpath="//a[text()='Contact Details']")
	WebElement contactDetails;
	
	@FindBy(xpath ="//label[text()='Street 1']/../../div[2]/input") 
	WebElement street1_field;
	
	@FindBy(xpath ="//label[text()='Street 2']/../../div[2]/input")
	WebElement street2_field;
	
	@FindBy(xpath ="//label[text()='City']/../../div[2]/input")
	WebElement city_field;
	
	@FindBy(xpath ="//label[text()='State/Province']/../../div[2]/input")
	WebElement state_field;
	
	@FindBy(xpath ="//label[text()='Zip/Postal Code']/../../div[2]/input")
	WebElement zipcode_field;
	
	@FindBy(xpath ="//label[text()='Country']/../../div[2]//div[@tabindex='0']")
	WebElement country_field;
	
	@FindBy(xpath ="//label[text()='Home']/../../div[2]/input") 
	WebElement home_phone;
	
	@FindBy(xpath ="//label[text()='Mobile']/../../div[2]/input") 
	WebElement mobile_phone;
	
	@FindBy(xpath ="//label[text()='Work']/../../div[2]/input") 
	WebElement work_phone;
	
	@FindBy(xpath ="//label[text()='Work Email']/../../div[2]/input")
	WebElement email_official;
	
	@FindBy(xpath ="//label[text()='Other Email']/../../div[2]/input")
	WebElement email_personal;
	
	@FindBy(xpath ="//button[@type='submit']") 
	WebElement SubmitBtn;
	
	@FindBy(id="oxd-toaster_1")
	WebElement popup;

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
		contactDetails.click();
	    System.out.println(driver.getCurrentUrl());
	    street1_field.sendKeys(Keys.CONTROL+ "a" + Keys.DELETE);	    
	    street1_field.sendKeys("ashby street");
	    street2_field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    street2_field.sendKeys("first cros");
	    city_field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);	
	    city_field.sendKeys("bramby");
	    state_field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);	 
	    state_field.sendKeys("vir");
	    zipcode_field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    zipcode_field.sendKeys("345678");
	    country_field.click();
	    country_field.sendKeys("aaa");
	    home_phone.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    home_phone.sendKeys("2323232323");
	    mobile_phone.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    mobile_phone.sendKeys("2323232323");
	    work_phone.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    work_phone.sendKeys("3434343434");
	    email_official.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    email_official.sendKeys("suba@gmail.com");
	    email_personal.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    email_personal.sendKeys("suba1@gmail.com");
	    SubmitBtn.click();
	    Thread.sleep(3000);
	    if(popup.isDisplayed())
	    {  String pop=  popup.getText();
	    	System.out.println(pop);		   
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
	

