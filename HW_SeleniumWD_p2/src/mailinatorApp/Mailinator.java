package mailinatorApp;

import googleApp.GoogleLogin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Mailinator {

	WebDriver driver;
	GoogleLogin googleLogin;
	
    public Mailinator(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
	public void goToMailinator() throws InterruptedException{
		
		String mailinatorUrl = "https://www.mailinator.com/";
		String mailinatorInBox = "mailinatormymail123@mailinator.com";	
		
		driver.get(mailinatorUrl);
		googleLogin = PageFactory.initElements(driver, GoogleLogin.class);
		new MailinatorBox(driver)
					.goToMailinatorBox(mailinatorInBox);
	}
	
	public void openMailinatorLetter() throws InterruptedException{
		
		String mailinatorUrl = "https://www.mailinator.com/";
		String mailinatorInBox = "mailinatormymail123@mailinator.com";	
		
		driver.get(mailinatorUrl);
		googleLogin = PageFactory.initElements(driver, GoogleLogin.class);
		new OpenReceivedLetter(driver)
					.openReceivedLetter(mailinatorInBox);
	}
}
