package googleApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendNewLetter {

	private WebDriver driver;
    
    @FindBy(className = "vO")
    private WebElement recipient;
        
    @FindBy(className = "aoT")
    private WebElement subject;

    @FindBy(className = "editable")
    private WebElement letterText;
    
    @FindBy(className = "aoO")
    private WebElement sendLetterButton;
    
    @FindBy(className = "vh")
    private WebElement letterSuccessfulSend;
    
    public SendNewLetter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public SendNewLetter sendNewLetter(String to, String subj, String text) throws InterruptedException{
    	recipient.sendKeys(to);
    	subject.sendKeys(subj);
    	letterText.sendKeys(text);
        sendLetterButton.click();
        Thread.sleep(2000);
		if (letterSuccessfulSend.isDisplayed())
		{
			System.out.println("Письмо отправлено");
		}
		else 
		{
			Thread.sleep(5000);
		}
        return new SendNewLetter(driver);
    }
}
