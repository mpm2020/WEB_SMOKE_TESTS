package Pages;

import Common.actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;



public class homePage extends actions {
    private WebDriver driver;
    public homePage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20),this);

    }

    @FindBy(xpath="//div[@class='app_logo']")
    static WebElement titlelabel;

    @FindBy(xpath="//*[text()='Sauce Labs Backpack']")
    static WebElement titlelabel_2;

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    static WebElement addCartBtn;

    public void hacerClicConActions() {
        Actions actions = new Actions(driver);
        actions.moveToElement(titlelabel_2).build().perform();
    }
    public void clickProduct() {
        click(addCartBtn);
    }

    public static boolean visiblelabel(){
        return isVisible(titlelabel);
    }

}
