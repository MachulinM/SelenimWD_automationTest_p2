package mainProject;

import mailinatorApp.MailinatorBox;
import googleApp.GoogleLogin;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainApp {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		String googleUrl = "https://www.google.com";
		String googleMail = "automationTestMail123@gmail.com";
		String googlePass = "a12345678A";
		
		String mailinatorUrl = "https://www.mailinator.com/";
		String mailinatorInBox = "mailinatormymail123@mailinator.com";
		
		driver.get(googleUrl);
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("Почта")).sendKeys(selectLinkOpeninNewTab);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		new GoogleLogin(driver)
					.loginToGoogle(googleMail, googlePass)
					.createNewLetter()
					.sendNewLetter(mailinatorInBox, "TestMail", "Here some text");
		driver.close();
		
		driver.switchTo().window(tabs.get(0));
				
		driver.get(mailinatorUrl);
		
		new MailinatorBox(driver)
					.goToMailinatorBox(mailinatorInBox);
		
		driver.quit();
	}

}
