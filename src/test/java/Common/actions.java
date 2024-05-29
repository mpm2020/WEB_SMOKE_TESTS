package Common;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class actions {
    // Método genérico para enviar texto a un elemento
    public static void setText(WebElement element, String text) {
        element.sendKeys(text);
    }

    // Método genérico para hacer clic en un elemento
    public static void click(WebElement element) {
        element.click();
    }

    // Método genérico para obtener el texto de un elemento
    public static String getText(WebElement element) {
        return element.getText();
    }

    // Método para verificar si un elemento está visible
    public static boolean isVisible(WebElement element) {
        return element.isDisplayed();
    }



}


