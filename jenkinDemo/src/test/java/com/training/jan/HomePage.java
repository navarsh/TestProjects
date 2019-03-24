package com.training.jan;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {
	
	static ExtentReports extent;
	static ExtentTest logger;
	
public static void main(String[]args) throws InterruptedException
{
	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/jenkinreport.html", true);
	//String path= "/Users/kumaranjayaraman/Desktop/Selenium_reports/jenkinreport.html";
	
	//extent =new ExtentReports(path);
	
	System.setProperty("webdriver.chrome.driver","/Users/kumaranjayaraman/Downloads/chromedriver");
	WebDriver driver=new ChromeDriver();
	WebDriverWait wait =new WebDriverWait(driver,40);
	driver.get("https://selenium-prd.firebaseapp.com");
	System.out.println("Application Launched");
	Thread.sleep(4000);
	
	logger =extent.startTest("LaunchApplication");
	//Enter the username and password
	
	WebElement username = driver.findElement(By.id("email_field"));
	username.clear();
	username.sendKeys("admin123@gmail.com");
	logger.log(LogStatus.PASS, " username entered successfully");
	
	//System.out.println("username entered successfully");
	
	WebElement password = driver.findElement(By.id("password_field"));
	password.clear();
	password.sendKeys("admin123");
	logger.log(LogStatus.PASS, " password entered successfully");
	//System.out.println("password entered successfully");
	
	//Click loginbutton
	
	WebElement LoginButton =driver.findElement(By.xpath("//button[@onclick='login()']"));
	LoginButton.click();
	logger.log(LogStatus.PASS, " LoginButton clicked successfully");
	//System.out.println("Login clicked successfully");
	
	Thread.sleep(5000);
	
	WebElement HomeTab =driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
	HomeTab.click();
	System.out.println("HomeTab clicked successfully");
	logger.log(LogStatus.PASS, " HomeTab clicked successfully");
	
	WebElement Name = driver.findElement(By.xpath("//input[@id='name']"));
	Name.sendKeys("Nivi");
	System.out.println("Name entered Successfully");
	

	WebElement FatherName = driver.findElement(By.xpath("//input[@id='lname']"));
	Name.sendKeys("M");
	System.out.println("FatherName entered Successfully");
	

	WebElement PostalAdress = driver.findElement(By.xpath("//input[@id='postaladdress']"));
	PostalAdress.sendKeys("576449");
	System.out.println("PostalAdress entered Successfully");
	
	WebElement PersonalAdress = driver.findElement(By.xpath("//input[@id='personaladdress']"));
	PersonalAdress.sendKeys("some street");
	System.out.println("PersonalAdress entered Successfully");
	
	WebElement Gender = driver.findElement(By.xpath("//div[@class='row']//span[2]//input[1]"));
	Gender.click();
	System.out.println("Gender entered Successfully");
	
	WebElement City = driver.findElement(By.xpath("//select[@id='city']//option[@value='mumbai'][contains(text(),'MUMBAI')]"));
	City.click();
	System.out.println("City entered Successfully");
	

	WebElement Course = driver.findElement(By.xpath("//option[contains(text(),'B.TECH')]"));
	Course.click();
	System.out.println("Course entered Successfully");
	

	WebElement District = driver.findElement(By.xpath("//select[@id='district']//option[@value='newdelhi'][contains(text(),'NEW DELHI')]"));
	District.click();
	System.out.println("District entered Successfully");
	
	WebElement State = driver.findElement(By.xpath("//option[contains(text(),'NALANDA')]"));
	State.click();
	System.out.println("State entered Successfully");
	
	WebElement Pincode = driver.findElement(By.xpath("//input[@id='pincode']"));
	Pincode.sendKeys("606787");
	System.out.println("Pincode entered Successfully");
	
	WebElement email = driver.findElement(By.xpath("//input[@id='emailid']"));
	email.sendKeys("nivi@salesforce.com");
	System.out.println("email entered Successfully");
	
	WebElement SubmitButton = driver.findElement(By.xpath("//input[@id='emailid']"));
	SubmitButton.click();
	System.out.println("SubmitButton entered Successfully");
	
	Thread.sleep(5000);
	
	WebElement SwitchTo = driver.findElement(By.xpath("//div[@class='navbar']//div[1]//button[1]"));
	SwitchTo.click();
	System.out.println("SwitchTo is clicked Successfully");
	
	WebElement Alert = driver.findElement(By.xpath("//a[contains(text(),'Alert')]"));
	Alert.click();
	System.out.println("Alert is clicked Successfully");
	
	
	WebElement WindowsAlert = driver.findElement(By.xpath("//button[contains(text(),'Window Alert')]"));
	WindowsAlert.click();
	System.out.println("WindowsAlert is clicked Successfully");
	
	//SwitchTo alert and print text
	
	Alert WindowAlert = driver.switchTo().alert();
	String alertText = WindowAlert.getText();
	System.out.println("Alert is:" + alertText);
	Thread.sleep(5000);
	WindowAlert.accept();
	
	WebElement PromptAlert = driver.findElement(By.xpath("//button[contains(text(),'Promt Alert')]"));
	PromptAlert.click();
	
	Alert Promptalert = driver.switchTo().alert();
	Thread.sleep(4000);
	Promptalert.sendKeys("nivi");
	Thread.sleep(4000);
	Promptalert.accept();
	
	extent.endTest(logger);
	extent.flush();
	extent.close();
	
	
}

}
