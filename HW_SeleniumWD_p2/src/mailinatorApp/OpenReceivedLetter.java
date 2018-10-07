package mailinatorApp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenReceivedLetter {
	
	private WebDriver driver;
	
    @FindBy(id = "inboxfield")
    private WebElement inputField;
	
    @FindBy(xpath = "html/body/div[1]/div/div[3]/div/div[6]/div/div/div/table/tbody/tr[1]/td[4]")
    private WebElement receivedLetter;
        
    public OpenReceivedLetter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public OpenReceivedLetter openReceivedLetter(String mailinatorInBox) throws InterruptedException{
    	inputField.sendKeys(mailinatorInBox, Keys.ENTER);
    	receivedLetter.click();
        return new OpenReceivedLetter(driver);
    }
}
