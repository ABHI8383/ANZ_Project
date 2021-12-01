package anz.stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Anzsteps {

	WebDriver driver;
	
	@Given("^launch the application and application type should be single$")
	public void launch_the_application_and_application_type_should_be_single() throws Throwable
	{
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path+"\\resorces\\chromedriver.exe");					
	    driver= new ChromeDriver();					
	    driver.manage().window().maximize();			
	    driver.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");	
	    driver.findElement(By.id("application_type_single")).click();							
	    
	}
	@And("^number of dependents should be zero$")
	public void number_of_dependents_should_be_zero() throws Throwable
	{
		Select dependents = new Select(driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[1]/div/div[2]/div/select")));
		dependents.selectByVisibleText("0");
	}
	@When("^property you would like to buy home to live in$")
	public void property_you_would_like_to_buy_home_to_live_in() throws Throwable
	{
		driver.findElement(By.id("borrow_type_home")).click();
	}
	@And("^enter income in earnings$")
	public void enter_income_in_earnings() throws Throwable
	{
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]/div/input")).sendKeys("80000");
	}
	@And("^enter other income in earnings$")
	public void enter_other_income_in_earnings() throws Throwable
	{
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/div/input")).sendKeys("10000");
	}
	@And("^enter living expenses in expenses$")
	public void enter_living_expenses_in_expenses_() throws Throwable
	{
		driver.findElement(By.id("expenses")).sendKeys("500");
	}
	@And("^enter current home loan repayments in expenses$")
	public void enter_current_home_loan_repayments_in_expenses() throws Throwable
	{
		driver.findElement(By.id("homeloans")).sendKeys("0");	
	}
	@And("^enter other loan repayments in expenses$")
	public void enter_other_loan_repayments_in_expenses() throws Throwable
	{
		driver.findElement(By.id("otherloans")).sendKeys("100");
	}
	@And("^enter other commitments in expenses$")
	public void enter_other_commitments_in_expenses() throws Throwable
	{
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[3]/div/div[4]/div/input")).sendKeys("0");
	}
	@And("^enter total credit card limits in expenses$")
	public void enter_total_credit_card_limits_in_expenses() throws Throwable
	{
		driver.findElement(By.xpath("/html/body/main/div/div[2]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/div/div[3]/div/div[5]/div/input")).sendKeys("10000");
	}
	@Then("^click on how much I could borrow$")
	public void click_on_how_much_i_could_borrow() throws Throwable
	{
		driver.findElement(By.id("btnBorrowCalculater")).click();
	}
	@Given("^click on start over$")
	public void click_on_start_over() throws Throwable
	{
		driver.findElement(By.className("start-over")).click();
	}
	@And("^enter living expenses in expenses again$")
	public void enter_living_expenses_in_expenses_again() throws Throwable
	{
		driver.findElement(By.id("expenses")).sendKeys("1");
	}
	@Then("^click on work out how much i could borrow$")
	public void click_on_work_outhow_much_i_could_borrow() throws Throwable
	{
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.id("btnBorrowCalculater"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().build().perform();
	//	driver.findElement(By.id("btnBorrowCalculater")).click();
	}
}
