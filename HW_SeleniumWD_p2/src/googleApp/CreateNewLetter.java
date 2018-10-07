package googleApp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLetter {

	private WebDriver driver;
	
    @FindBy(xpath = "html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[1]/div[2]/div/div/div/div[1]/div/div")
    private WebElement writeLetterButton;
    
    public CreateNewLetter(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public SendNewLetter createNewLetter() throws InterruptedException{
    	writeLetterButton.click();
        return new SendNewLetter(driver);
    }
}
