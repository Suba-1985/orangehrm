package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.HrmOrangeProject.Page.LeavePage;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.HrmOrangeProject.Page.*;


public class LeavePage_SD {
	public static WebDriver driver;
	 LeavePage leavePage;
	 final String homePageUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"; 
	 WebDriverWait wait;
	
	
//	public LeavePage_SD(WebDriver driver) {
//		super(driver);
//		PageFactory.initElements(driver, this);	
//	}	
	
	@Given("^User logins in to the OrangeHRM application with valid username and password$")
	public void User_logins_in_to_the_OrangeHRM_application_with_valid_username_and_password() {
		
//		System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\ChromeDriver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(homePageUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    wait = new WebDriverWait(driver, Duration.ofSeconds(3));	
	    leavePage=new LeavePage(driver);
	  	PageFactory.initElements(driver, this);	
		leavePage.uName.sendKeys("admin");
		leavePage.pwd.sendKeys("admin123");
		leavePage.loginBtn.click();	
		System.out.println(driver.getCurrentUrl());		
	}

	@When("^User Navigates to Leave menu in the OrangeHRM application$")
	public void user_navigates_to_leave_menu_in_the_orange_hrm_application() {
	    leavePage.leave.click();
	}

	@When("^user clicks apply link leave screen in the application$")
	public void user_clicks_apply_link_leave_screen_in_the_application() {
	   leavePage.apply.click();
	}

	@Then("^User should be able to view assign leave screen in orange hrm application$")
	public void user_should_be_able_to_view_assign_leave_screen_in_orange_hrm_application() {
	   String msg=leavePage.leavemsg.getText();
	   System.out.println(msg);
	}

	@When("^user selects personal leave in leave screen of orange hrm application$")
	public void user_selects_personal_leave_in_leave_screen_of_orange_hrm_application() {
	   leavePage.myleave.click();
	   leavePage.select.click();
	   leavePage.leavetype.click();
	}

	@Then("^User able to view the leave balance in leave screen of orange hrm$")
	public void user_able_to_view_the_leave_balance_in_leave_screen_of_orange_hrm() {
	   	    leavePage.search.click();
	   	    String msg1= leavePage.searchresult.getText();
	   	    System.out.println(msg1);
	}

	@When("^user selects from and to dates in leave screen of orange hrm application$")
	public void user_selects_from_and_to_dates_in_leave_screen_of_orange_hrm_application() {
	   leavePage.assignleave.click();
	   leavePage.fromcalender.sendKeys(Keys.CONTROL+"a");
	   leavePage.fromcalender.sendKeys("2023-05-01");
	   leavePage.tocalender.sendKeys(Keys.CONTROL+"a");
	   leavePage.tocalender.sendKeys("2023-05-02");
	}

	@When("user enters comment as {string} in leave screen in orange hrm application")
	public void user_enters_comment_as_in_leave_screen_in_orange_hrm_application(String string) {
	   leavePage.comments.sendKeys(string);
	   
	}

	@When("^user clicks apply button in leave screen of orange hrm application$")
	public void user_clicks_apply_button_in_leave_screen_of_orange_hrm_application() {
		leavePage.assign.click();
		leavePage.alert2.click();
		wait.until(ExpectedConditions.visibilityOf(leavePage.partialdays));
		leavePage.partialdays.click();
		leavePage.alldays.click();
    	wait.until(ExpectedConditions.visibilityOf(leavePage.duration));
    	leavePage.duration.click();
    	wait.until(ExpectedConditions.elementToBeClickable(leavePage.halfday));
    	leavePage.halfday.click();
    	leavePage.assign.click();
	}

	@Then("^user is able to view success message in leave screen of orange hrm application$")
	public void user_is_able_to_view_success_message_in_leave_screen_of_orange_hrm_application(io.cucumber.datatable.DataTable dataTable) {
		  String s3= leavePage.leave.getText();
		   System.out.println(s3);
		   leavePage.cancel.click();
		   leavePage.userdropdown.click();
		   leavePage.logout.click();
	}
}
