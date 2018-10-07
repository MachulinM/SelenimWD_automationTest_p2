package googleApp;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleLogin {

	private WebDriver driver;
    
    @FindBy(xpath = "html/body/nav/div/a[2]")
    private WebElement enterLink;
        
    @FindBy(id = "identifierId")
    private WebElement loginField;

    @FindBy(name = "password")
    private WebElement passwordField;
    
    public GoogleLogin(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public CreateNewLetter loginToGoogle(String login, String password) {
    	enterLink.click();
        loginField.sendKeys(login, Keys.ENTER);
        passwordField.sendKeys(password, Keys.ENTER);
        return new CreateNewLetter(driver);
    }
}
