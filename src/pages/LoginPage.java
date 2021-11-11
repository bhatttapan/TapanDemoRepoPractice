package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class LoginPage {
	
	WebDriver driver;
	
	public void openBrowser() throws IOException
	{
		FileInputStream f= new FileInputStream("C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Testing\\Prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		
		
         String browser = prop.getProperty("browser");
         System.out.println(browser);
		 //String browser = "Chrome";
		 if(browser.equals("Firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Seleniumjars\\geckodriver-v0.29.1-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browser.equals("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver","C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Seleniumjars\\chromedriver_win32 (1)\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else
			{
				System.setProperty("webdriver.safari.driver","C:\\TAPAN\\STUDY\\QUALITY ASSURANCE NIKUL SIR\\Seleniumjars\\chromedriver_win32 (1)\\safaridriver.exe");
				driver = new SafariDriver();
			}
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}
	
	public void openLoginPage()
	{
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=whHscKQX34g&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5Ijoid2hIc2NLUVgzNGciLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYzMDI2OTY0NywiaWF0IjoxNjMwMjY4NDQ3LCJqdGkiOiJlMzc3Mjk5ZS0yNjlkLTQyODktYTVkMy03NTMyZjMzMWJjMjUiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.d0z5ukquMVq2sjw0Jz-lPbudccUoqIyjQe1fN3_U9tRlp7rXQRRgL7KS7tmk1jaslll_4V5uzVUEc0LieK6WQ7OoxxyQ4jtKHEzGFhP59AUwslq6Sx_mGy8LEWB7v7Y8npfSaPZ6XVvoA1j_JPdpGVz8WP95axPHWN3O4AVF_X0S5Nt4HuPFKY2SYlrW5ZX2z4QTh2S4dBOtX3GptFYf6kcmI6JXocvV7y4Jp70YZTh719D9CVr524WtEdAyXQH2jmB6sS3SMRwnZxg09diWZW1E2FbJj7uBQAOitaQsBUCI836mrz3tQ6dupJY-t0wvfwDCyRVsvlefjfTgERt2JQ&preferred_environment=");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void logIn(String a, String b) throws InterruptedException
	{
		driver.findElement(By.name("usernameInput")).sendKeys(a);
		driver.findElement(By.name("password")).sendKeys(b);
		driver.findElement(By.id("signIn")).click();
		Thread.sleep(2000);
	}
	
	public String readGlobalErr()
	{
		String actualErr = driver.findElement(By.id("globalError")).getText();
		System.out.println(actualErr);
		return actualErr;
	}
	
	public String readLocalErr()
	{
		String actualErr = driver.findElement(By.className("Error__text")).getText();
		System.out.println(actualErr);
		return actualErr;
	}

}
