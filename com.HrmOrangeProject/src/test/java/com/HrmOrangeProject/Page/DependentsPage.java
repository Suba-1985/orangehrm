package com.HrmOrangeProject.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DependentsPage extends RecruitmentPage{
	WebDriverWait wait;
	List<WebElement> addlist;
	RecruitmentPage recruitmentPage;
	public DependentsPage()
	{     
		this.driver=driver;	     
		 PageFactory.initElements(driver, this);	
		 recruitmentPage=new RecruitmentPage();
	}
	
	@FindBy(xpath="//span[text()='My Info']")
	WebElement myInfo;
	
	@FindBy(xpath="//a[text()='Dependents']")
	WebElement dependents;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--text'][1]")
	WebElement add_Btn;
	
	
	
	@FindBy(xpath="//label[text()='Name']/../..//input")
	WebElement name_field;
	
	@FindBy(xpath="//label[text()='Relationship']/../../div[2]//div[@tabindex='0']")
	WebElement relationship_field;
	
	@FindBy(xpath="//label[text()='Home Telephone']/../..//input")
	WebElement dob_field;

	
	@FindBy(xpath="//button[@type='submit']")
	WebElement save_btn;
	@FindBy(xpath="//label[text()='Date of Birth']/../..//input")
	WebElement cal_field;
	
	
	
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
			dependents.click();
			System.out.println(driver.getCurrentUrl());
			int i;
			addlist=driver.findElements(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text']"));
			for(i=0;i<=addlist.size();i++)
			{
				driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--text'][i]")).click();
			}		
		    name_field.sendKeys(Keys.CONTROL+ "a" + Keys.DELETE);	    
		    name_field.sendKeys("nithyadepend");
		    relationship_field.click();
		    relationship_field .sendKeys("c" + Keys.ENTER);
		    cal_field.sendKeys("09-06-2023");
		    Thread.sleep(2000);		 
		    save_btn.click();
		    Thread.sleep(3000);
		    if(popup.isDisplayed())
		    {
		    	System.out.println("saved succeccfully");		   
		    }
		    else
		    {
		    	System.out.println("save was not successfull");
		    }	   
		    		    
		}
		@AfterMethod
		public void tearDown()
		{
			driver.quit();
		}
}
