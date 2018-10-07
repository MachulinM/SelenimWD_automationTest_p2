package mailinatorApp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailinatorBox {

	private WebDriver driver;
	
    @FindBy(id = "inboxfield")
    private WebElement inputField;
    
    public MailinatorBox(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public MailinatorBox goToMailinatorBox(String mailinatorInBox)throws InterruptedException{
    	inputField.sendKeys(mailinatorInBox, Keys.ENTER);
        return new MailinatorBox(driver);
    }
}
