package com.HrmOrangeProject.Page;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public  class RecruitmentPage {
	
	public WebDriver driver;
	final String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; 
	List<WebElement> list1;
	WebDriverWait wait;
	Actions act;

	public RecruitmentPage()
	{		   
		  PageFactory.initElements(driver, this);		 	
	}
	
	@FindBy(xpath="//li[@class='oxd-userdropdown']/span/p")
	WebElement name_click;
	
	@FindBy(xpath="//input[@name='username' or @placeholder='username']")
	WebElement uName;
	
	@FindBy(id="welcome")
	WebElement welcomeUser;
 
	@FindBy(xpath="//span[text()='Recruitment']")
	WebElement recruit_link;
	
	@FindBy(xpath="//input[@placeholder='password' or @name='password']")
	WebElement pwd;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="class='oxd-topbar-header-breadcrumb'")
	WebElement dashBoard;
	
	@FindBy(xpath="//a[@class='oxd-brand']")
	WebElement orangeHrm;	
	
	@FindBy(name="firstName")
	WebElement first_name;
	
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement add_btn;
	
	@FindBy(name="middleName") 
	WebElement middle_name;
	
	@FindBy(name="lastName")
	WebElement last_name;
	
	@FindBy(xpath ="//label[text()='Vacancy']/../..//div[2]/div/div//div[@tabindex='0']")
	WebElement vacancy_field;
	
	@FindBy(xpath ="//label[text()='Email']/../..//input")
	WebElement email_field;
	
	@FindBy(xpath ="//label[text()='Contact Number']/../..//input")
	WebElement contact_field;
	
	@FindBy(xpath ="//label[text()='Keywords']/../..//input")
	WebElement keywords_field;
	
	@FindBy(xpath ="//label[text()='Date of Application']/../.././/div[2]/div/div//input") 
	WebElement calendar;
	
	@FindBy(xpath ="//input[@type='checkbox']") 
	WebElement chkBox_chk;
	
	@FindBy(xpath ="//button[@type='submit']") 
	WebElement SubmitBtn;
	
	@FindBy(id="oxd-toaster_1")
	WebElement popup;
	
	@FindBy(xpath="//button[text()=' Shortlist ']")
	WebElement shortlist_btn;
	
	@FindBy(xpath="//label[text()='Candidate']/../..//input")
	WebElement candidate ;
	
	@FindBy(xpath="//label[text()='Notes']/../..//div//textarea")
	WebElement notes;
	
	@FindBy(xpath="//*[@id='app']/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]")
	WebElement schedule_Interview;
	
	@FindBy(xpath="//span[text()='Admin']")
	WebElement admin_tab;
	
	@FindBy(xpath="//label[text()='Username']/../..//input")
	WebElement username_adminfield;
	
	@FindBy(xpath="//label[text()='User Role']/../..//div[2]/div/div//div[@tabindex='0']")
	WebElement userRole_admin;
	
	@FindBy(xpath="//label[text()='Employee Name']/../..//input")
	WebElement Empname_admin;
	
	@FindBy(xpath="//label[text()='Status']/../..//div[2]/div/div//div[@tabindex='0']")
	WebElement status_admin;
	
	@FindBy(xpath="//button[text()=' Search ']")
	WebElement searchbtn_admin;
	
	@FindBy(xpath="//label[text()='Password']/../..//input")
	WebElement password_admin;
	
	@FindBy(xpath="//label[text()='Confirm Password']/../..//input")
	WebElement con_password;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveBtn_admin;
	
	@FindBy(xpath="//label[text()='Interview Title']/../..//input")
	WebElement interview_title;
	
	@FindBy(xpath="//label[text()='Interviewer']/../..//input")
	WebElement interviewer;
	
	@FindBy(xpath="//label[text()='Date']/../..//input")
	WebElement calendar2_schedule;
	
	@FindBy(xpath="//button[text()=' Mark Interview Passed ']")
	WebElement pass;
	
	@FindBy(xpath="//button[text()=' Offer Job ']")
	WebElement offer_job;
	
	@FindBy(xpath="//button[text()=' Hire ']")
	WebElement hire_btn;
	
	


	@BeforeMethod   //Setting the Driver
	public void loginSetup()
	{ 	
	System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\ChromeDriver\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.get(homePageUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    wait = new WebDriverWait(driver, Duration.ofSeconds(3));	
  	PageFactory.initElements(driver, this);	
    act=new Actions(driver);
	uName.sendKeys("Admin");
	pwd.sendKeys("admin123");
	loginBtn.click();	
	System.out.println(driver.getCurrentUrl());		
   }
	
	@Test(priority=1)
	public void homePageUrlChk()
	{
		String expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(actual, expected,"URL TestCase Passed");
	}
	
	public String popup_chk() throws InterruptedException
	{
		String poptxt = driver.findElement(By.id("oxd-toaster_1")).getText();
		Thread.sleep(1000);		
			if (poptxt.contains("Success")) {				
				//return "Success";
			}
			else  
		    {//	return "Failure";
		    }	return "Success";	
	}			
	
	@Test(priority=2)
	public void recruitmentPageTest() throws InterruptedException
	{   act=new Actions(driver);
		recruit_link.click();
	    add_btn.click();	  
	    first_name.sendKeys(Keys.CONTROL+ "a" + Keys.DELETE);	    
	    first_name.sendKeys("Sam");	 
	    last_name.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);	
	    last_name.sendKeys("Morris");
	    vacancy_field.click();
	    vacancy_field.sendKeys("se");
	    Thread.sleep(3000);
	    vacancy_field.sendKeys(Keys.DOWN);
	    vacancy_field.sendKeys(Keys.ENTER);
	    email_field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    email_field.sendKeys("nn@gmail.com");
	    contact_field.sendKeys("3456789434");
	    keywords_field.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    keywords_field.sendKeys("tester, QA");
	    calendar.sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
	    calendar.sendKeys("2023-06-02");	    
	    act.scrollToElement(chkBox_chk).click();
	    Thread.sleep(1000);	  
	    SubmitBtn.click();
	   // Thread.sleep(1000);	  
	  //  String popText=popup_chk();
	  //  System.out.println(popText);	    
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView;", shortlist_btn);			
	    shortlist_btn.click();
	    String popText1=popup_chk();
	    System.out.println(popText1);
	    notes.sendKeys("test shorlist");
	    saveBtn_admin.click();
	    Thread.sleep(3000);
	    schedule_Interview.click();
	    interview_title.sendKeys("HrInterview");
		interviewer.click();
		interviewer.sendKeys("o");
		Thread.sleep(4000);
		interviewer.sendKeys(Keys.DOWN);
		interviewer.sendKeys(Keys.ENTER);
	    calendar2_schedule.sendKeys("2023-06-02");
	    Thread.sleep(3000);
	    js.executeScript("arguments[0].scrollIntoView;", saveBtn_admin);
	    saveBtn_admin.click(); 
	    pass.click();
	    saveBtn_admin.click();
	    offer_job.click();
	    saveBtn_admin.click();
	    hire_btn.click();
	    saveBtn_admin.click();
	    printCandidate();
	}
	
	public void printCandidate()
	{
	//	int cols=driver.findElements(By.xpath("//div[@class='oxd-table']//div//div//div[@role='columnheader']")).size();
		int rows=driver.findElements(By.xpath("//div[@class='oxd-table']//div[contains(@class,'oxd-table-body')]//div[@role='row']")).size();
		for(int i=1;i<=rows;i++)
		{	
			String txt=driver.findElement(By.xpath("//div[@class='oxd-table']//div[contains(@class,'oxd-table-body')]//div[@role='row']")).getText();
			System.out.println(txt);		
		}
		System.out.println("---------------------------------------------------");	
	
   }	
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{	
		Thread.sleep(3000);
		driver.quit();
	}
}
	
	
//@@@@@@@@@ Unwanted Code ##########
//public  void clearInput()
//{
//	List<WebElement> in= driver.findElements(By.tagName("input"));
//	int i= in.size();
//	System.out.println(i);
//	for(int j=1; j<=i; j++)
//     {         
//         in.get(j).clear();
//         System.out.println("im clearing" + j);
//         driver.findElement(By.tagName("input["+j+"]")).sendKeys("  ");
//        
//     }
//} 	

//public void selectOptionWithText(String texttoSelect)
//{try {
//	WebElement autoOptions = driver.findElement(By.xpath("//div[contains(@class,'oxd-autocomplete-wrapper')]"));
//	wait.until(ExpectedConditions.visibilityOf(autoOptions));
//
//	List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName("input"));
//	for(WebElement option : optionsToSelect){
//        if(option.getText().equals(texttoSelect)) {
//        	System.out.println("Trying to select: "+texttoSelect);
//            option.click();
//            break;
//        }
//    }
//	
//} catch (NoSuchElementException e) {
//	System.out.println(e.getStackTrace());
//}
//catch (Exception e) {
//	System.out.println(e.getStackTrace());
//}
//}
	


