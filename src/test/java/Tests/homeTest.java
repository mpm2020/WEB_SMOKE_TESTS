
package Tests;

import Common.screenShot;
import Common.commonSetup;
import Data.validLoginDataProvider;
import Pages.homePage;
import Pages.loginPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class homeTest extends commonSetup {
    private static final Logger logger = LogManager.getLogger(commonSetup.class);
    loginPage login;
    homePage home;
    @Test(dataProvider="Datos Login",dataProviderClass= validLoginDataProvider.class)
    public void accountValid(String user,String pass) throws Exception {

        try {
            login= new loginPage(driver);
            login.Credential(user, pass);
            login.clickLogin();
            home = new homePage(driver);
            Assert.assertTrue(homePage.visiblelabel());
            home.hacerClicConActions();
            home.clickProduct();

            // Home
            logger.info("WEBSITE");

         } catch (Exception e) {
              logger.error("WEBSITE GIT", e);
              screenShot.takeScreenShot(driver, "LBL_ACCOUNT");
              Assert.fail("Exception: " + e.getMessage());
        }
    }

}
