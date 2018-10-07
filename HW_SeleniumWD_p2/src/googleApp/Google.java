package googleApp;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Google {
	
	WebDriver driver;
	GoogleLogin googleLogin;

    public Google(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void LoginInGoogle()throws InterruptedException{
		
		String googleUrl = "https://www.google.com";
		String googleMail = "automationTestMail123@gmail.com";
		String googlePass = "a12345678A";
		String mailObject = "TestMail"; 
		String mailText = "Here some text"; 
		String mailinatorInBox = "mailinatormymail123@mailinator.com";
		
		driver.get(googleUrl);
		
		String selectLinkOpeninNewTab = Keys.chord(Keys.CONTROL,Keys.RETURN);
		driver.findElement(By.linkText("Почта")).sendKeys(selectLinkOpeninNewTab);
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		
		new GoogleLogin(driver)
		.loginToGoogle(googleMail, googlePass)
		.createNewLetter()
		.sendNewLetter(mailinatorInBox, mailObject, mailText);
		
		driver.switchTo().window(tabs.get(0));
	}
}
