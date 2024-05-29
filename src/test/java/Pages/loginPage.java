package Pages;

import Common.actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class loginPage extends actions {

    public loginPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20),this);

    }

    @FindBy(name="user-name")
    WebElement emailTextBox;

    @FindBy(name="password")
    WebElement passwordTextBox;

    @FindBy(name="login-button")
    static WebElement nextButton;


    public void enterEmail(String email) {
        setText(emailTextBox, email);
    }

    public void enterPassword(String password) {
        setText(passwordTextBox, password);
    }

    public void clickLogin() {
        click(nextButton);
    }

    public void Credential(String email, String password) {
        enterEmail(email);
        enterPassword(password);
    }
    public static boolean Visible(){
        return isVisible(nextButton);
    }
}
