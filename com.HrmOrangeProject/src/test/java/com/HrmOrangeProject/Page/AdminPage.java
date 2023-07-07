package com.HrmOrangeProject.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminPage {
	
	public WebDriver driver;
	final String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; 
	List<WebElement> list1;
	WebDriverWait wait;
	Actions act;
	
	public AdminPage()
	{		   
		  PageFactory.initElements(driver, this);		 	
	}
	
	@FindBy(xpath="//li[@class='oxd-userdropdown']/span/p")
	WebElement name_click;
	
	@FindBy(xpath="//input[@name='username' or @placeholder='username']")
	WebElement uName;
	
	@FindBy(id="welcome")
	WebElement welcomeUser; 
	
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
	WebElement empname_admin;
	
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
	
	@FindBys(value = { @FindBy(how = How.CLASS_NAME,using="oxd-table-card")})
	public List<WebElement> rows;
	
	
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
	@Test(priority=3,dataProvider="userEnroll")
	public void searchAdminTab(String ur,String e_name,String status,String un,String pwd,String cpwd) throws InterruptedException
	{
		admin_tab.click();
		username_adminfield.sendKeys(un);
		userRole_admin.click();
		userRole_admin.sendKeys(ur);
		Thread.sleep(3000);
		userRole_admin.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
		userRole_admin.sendKeys(Keys.ENTER);
		empname_admin.sendKeys(e_name);
		Thread.sleep(4000);
		empname_admin.sendKeys(Keys.ARROW_DOWN);
		empname_admin.sendKeys(Keys.ENTER);
		status_admin.click();
		status_admin.sendKeys(status);
		Thread.sleep(2000);
		status_admin.sendKeys(Keys.ARROW_DOWN);
		status_admin.sendKeys(Keys.ENTER);
		Actions act=new Actions(driver);
		act.moveToElement(searchbtn_admin).click().perform();
		if(popup.isDisplayed())
		{
			System.out.println(popup.getText());
		}else
		{
			System.out.println(popup.getText());
		}
		String status_chk=driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[2]/div/span")).getText();
		System.out.println(status_chk);
		
		Thread.sleep(3000);
		if(status_chk.contains("No Record Found"))
		{
		System.out.println("No record found***");
		}
		else
		{
			statusCheck();
		}		
	}
	
	public void statusCheck()
	{
		String txt=driver.findElement(By.xpath("//div[@class='orangehrm-container']")).getText();
		System.out.print("Record Found :" +txt +"  ");
	}
	
	@DataProvider(name="userEnroll")
	public String[][] testData()
	{String[][] data = null;

      String ur = "Es";
      String e_name = "Sam";
      String status = "En";
      String un = "SamMorris2";
      String pwd = "Numpy@ninja1";
      String cpwd = "Numpy@ninja1";
   
      data = new String[][] { { ur,e_name,status,un,pwd,cpwd}};
		
	    return data;
	}
	
	@Test(priority=1,dataProvider="userEnroll")
	public void addUserAdminTab(String ur,String e_name,String status,String un,String pwd,String cpwd) throws InterruptedException
	{
		admin_tab.click();
		add_btn.click();
		userRole_admin.click();
		userRole_admin.sendKeys(ur);
		Thread.sleep(3000);
		userRole_admin.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN);
		userRole_admin.sendKeys(Keys.ENTER);		
		empname_admin.sendKeys(e_name);
		Thread.sleep(3000);
		empname_admin.sendKeys(Keys.ARROW_DOWN);
		empname_admin.sendKeys(Keys.ENTER);		
		status_admin.click();
		status_admin.sendKeys(status);
		status_admin.sendKeys(Keys.ARROW_DOWN);
		status_admin.sendKeys(Keys.ENTER);		
		username_adminfield.sendKeys(un);
		password_admin.sendKeys(pwd);
		con_password.sendKeys(cpwd);
		saveBtn_admin.click();
		if(popup.isDisplayed())
		{
			System.out.println(popup.getText());
		}
		else
			System.out.println(popup.getText());
		    Thread.sleep(3000);
	}
	@Test(priority=2,dataProvider = "userEnroll")
	public void logOut(String ur,String e_name,String status,String un,String pwd,String cpwd)
	{
		name_click.click();
		list1=driver.findElements(By.xpath("//ul[@class='oxd-dropdown-menu']/li"));
		for(WebElement menu:list1)
		{
			if(menu.getText().equalsIgnoreCase("Logout"))
			{
				menu.click();
			}			
		}
		driver.get(homePageUrl);
		uName.sendKeys(un);
		password_admin.sendKeys(pwd);
		loginBtn.click();		
		String actual=driver.getCurrentUrl();
		String expected="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		Assert.assertEquals(actual, expected);
		
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.quit();
	}
}
