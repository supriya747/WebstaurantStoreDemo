package auto.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import static java.util.concurrent.TimeUnit.SECONDS;

public class Initialization  {

	private static final String URL = "https://www.webstaurantstore.com/";
	
    protected WebDriver driver = null;
    private static final long IMPLICIT_TIME = 7;


    @BeforeMethod(alwaysRun = true)
    public void loadurl() {
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIME, SECONDS);
        driver.manage().window().maximize();
    }


    @AfterMethod(alwaysRun = true)
    public void close() {
        if (driver != null)
            driver.quit();
    }
}
