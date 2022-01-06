package tests;

import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
//import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeClass;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;


public class LoginTest {
	
	WebDriver driver;
	LoginPage lp = new LoginPage();
	DataFile df = new DataFile();
	
	//static ExtentTest test;
	//static ExtentReports report;
	
	
	
	
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
	    lp.openBrowser();
		lp.openLoginPage();
  }

  
  @AfterMethod
  public void afterMethod() {
	  
	  lp.closeBrowser();
  }

  
  @Test (priority=1)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException 
  {
	    lp.logIn(df.wrongEmail,df.wrongPassword);
		Assert.assertEquals(lp.readGlobalErr(), df.globalErrMsg);
  }
  
  @Test (priority=2)
  public void loginWithEmptyEmailTest() throws InterruptedException
  {
	    lp.logIn("",df.wrongPassword);
		Assert.assertEquals(lp.readLocalErr(), df.emptyEmailErrMsg);
  }
  
  @Test (priority=3)
  public void loginWithEmptyPasswordTest() throws InterruptedException
  {
	        lp.logIn(df.wrongEmail,"");
			Assert.assertEquals(lp.readLocalErr(), df.emptyPasswordErrMsg);
  }
  
  @Test (priority=4)
  public void loginWithinvalidEmailTest() throws InterruptedException
  {
	    lp.logIn(df.invalidEmail,df.wrongPassword);
		Assert.assertEquals(lp.readLocalErr(), df.invalidEmailErrMsg);
  }
  
  
}
