package unitTest;

import java.util.concurrent.TimeUnit;

import googleApp.Google;
import mailinatorApp.Mailinator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class UnitTest {

	WebDriver driver;
	Google google;
	Mailinator mailinator;
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
    public void afterScenario() throws InterruptedException{
		Thread.sleep(3000);
		driver.quit();
    }	
	
	@Test
	public void Test1() throws InterruptedException{
		google = PageFactory.initElements(driver, Google.class);
		mailinator = PageFactory.initElements(driver, Mailinator.class);
		
		google.LoginInGoogle();
		Thread.sleep(2000);
		mailinator.goToMailinator();
		
		Assert.assertEquals("Username Userlastname", driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[6]/div/div/div/table/tbody/tr[1]/td[3]")).getText());
		Assert.assertEquals("TestMail", driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[6]/div/div/div/table/tbody/tr/td[4]")).getText());
	}
	
	@Test
	public void Test2()throws InterruptedException{
		mailinator = PageFactory.initElements(driver, Mailinator.class);
		mailinator.openMailinatorLetter();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("html/body/div[1]/div/div[3]/div/div[7]/div/div/div[2]/iframe")));
		Assert.assertEquals("Here some text", driver.findElement(By.xpath("html/body/div[1]")).getText());
		driver.switchTo().defaultContent();
	}
}
