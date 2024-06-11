package Common;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class screenShot {

    public static void takeScreenShot(WebDriver driver, String nameFile) throws IOException {
        if (driver instanceof TakesScreenshot) {
            // Captura la evidencia
            TakesScreenshot screenshotDriver = (TakesScreenshot) driver;
            File screenshotFile = screenshotDriver.getScreenshotAs(OutputType.FILE);
            // Genera una marca de tiempo con la fecha y hora actual
            SimpleDateFormat setformatdate = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String setTime = setformatdate.format(new Date());
            String directoryPath = "ScreenShots";
            File directory = new File(directoryPath);

            // Crear la carpeta si no existe
            if (!directory.exists()) {
                directory.mkdirs();
            }
            FileUtils.copyFile(screenshotFile, new File(directoryPath + "\\"+ nameFile + "-" + setTime + ".png"));
        }
    }
}

