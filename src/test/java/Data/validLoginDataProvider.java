
package Data;
import org.testng.annotations.DataProvider;

public class validLoginDataProvider {

    @DataProvider(name="Datos Login")
    public Object[][] getData(){

        return new Object[][] { {"standard_user", "secret_sauce"} };
    }
}
