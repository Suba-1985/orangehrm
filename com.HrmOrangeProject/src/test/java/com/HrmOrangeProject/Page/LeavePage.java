package com.HrmOrangeProject.Page;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class LeavePage {
	public static WebDriver driver;
	final String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; 
	List<WebElement> list1;
	WebDriverWait wait;
	Actions act;
	LeavePage leavePage;
	
	public LeavePage(WebDriver driver)
	{		   
		  PageFactory.initElements(driver, this);		 	
	}
	
	@CacheLookup
	@FindBy(xpath="//li[@class='oxd-userdropdown']/span/p")
	WebElement name_click;
	
	//@CacheLookup
	@FindBy(xpath="//input[@name='username' or @placeholder='username']")
	public WebElement uName;
	
	//@CacheLookup
	@FindBy(id="welcome")
	WebElement welcomeUser; 
	
	//@CacheLookup
	@FindBy(xpath="//input[@placeholder='password' or @name='password']")
	public	WebElement pwd;
	
	@CacheLookup
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginBtn;
	
	
	@FindBy (xpath = "//div[@id='app']/div/div/aside/nav/div[2]/ul/li[3]/a/span")
	public	WebElement leave;
	
	@FindBy (xpath = "//a[text()='Apply']")
	public	WebElement apply;
	
	@FindBy (xpath = "//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
	public	WebElement leavemsg;
	
	 @FindBy (xpath= "//a[text()='My Leave']")
	public	 WebElement myleave;
	 
	@FindBy (xpath= "//div[text()='-- Select --']")
	public	WebElement select;
	
	@FindBy (xpath = "//div[@role='listbox']//*[text()='US - Personal']")
	public	WebElement leavetype;
	
	@FindBy (xpath = "//button[@type='submit']")
	public	WebElement search;
	
	@FindBy (xpath = "//span[text()='No Records Found']")
	public WebElement searchresult;
	
	@FindBy (xpath = "//a[text()='Assign Leave']")
	public WebElement assignleave;
	
	@FindBy (xpath = "//input[@placeholder='Type for hints...']")
	WebElement empname;
	
	@FindBy (xpath = "//div[@role='listbox']/div[2]/span")
	WebElement empname2;
	
	@FindBy (xpath = "//div[text()='-- Select --']")
	WebElement leavetype2;
	
	@FindBy (xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[1]/div/div/div/div/input")
	public WebElement fromcalender;
	
	@FindBy (xpath = "//div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[2]/div/div/div/div/input")
	public WebElement tocalender;
	
	@FindBy (xpath = "//textarea")
	public	WebElement comments;
	
	@FindBy (xpath = "//button[@type='submit']")
	public	WebElement assign;
	
	@FindBy (xpath = "//div[@class='orangehrm-modal-footer']/button[2]")
	public	WebElement alert2;
	
	@FindBy (xpath= "//div/div/div[text()='-- Select --']")
	public	WebElement partialdays;
	
	@FindBy (xpath = "//div[@role='option'][2]/span")
	public	WebElement alldays;
	
	@FindBy (xpath = "//div[text()='-- Select --']")
	public	WebElement duration;
	
	@FindBy (xpath = "//div[@role='listbox']/div[2]")
	public	WebElement halfday;
	
	@FindBy (xpath = "//p[@class='oxd-text oxd-text--p oxd-text--subtitle-2']")
	WebElement noleave;
	
	@FindBy (xpath = "//div[@class='orangehrm-modal-footer']/button[1]")
	public WebElement cancel;
	
	@FindBy (xpath = "//p[@class='oxd-userdropdown-name']")
	public	WebElement userdropdown;
	
	@FindBy (xpath = "//a[text()='Logout']")
	public WebElement logout;
	

	
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
	
	public void leavePageTest()
	{
		leave.click();
		apply.click();
		myleave.click();
		select.click();
		leavetype.click();
		fromcalender.sendKeys(Keys.CONTROL+"a");
		fromcalender.sendKeys("2023-04-01");
		tocalender.sendKeys(Keys.CONTROL+"a");
		tocalender.sendKeys("2023-04-02");
		
		wait.until(ExpectedConditions.visibilityOf(duration));
		duration.click();
		
	}
	
	
	@AfterMethod
	public void tearDown() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.quit();
	}
}
