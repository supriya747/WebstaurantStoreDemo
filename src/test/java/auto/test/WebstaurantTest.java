package auto.test;

import org.testng.annotations.Test;
import auto.pages.WebstaurantPage;
import auto.utility.Initialization;

public class WebstaurantTest extends Initialization {

    @Test()
    public void webstaurantStore() throws InterruptedException {
    	WebstaurantPage webstaurantStore = new WebstaurantPage(driver);
    	webstaurantStore.itemValidation();
    	webstaurantStore.productvalidation();

    }
}
