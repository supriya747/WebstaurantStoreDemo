package auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class WebstaurantPage {

    WebDriver driver;

    public WebstaurantPage(WebDriver driver) {
        this.driver = driver;
    }


    public void itemValidation() throws InterruptedException {
    	int count1=0;
    	int count2=0;
    	
    	driver.findElement(By.id("searchval")).sendKeys("stainless steel work tables");
    	driver.findElement(By.xpath("//button[@value='Search']")).click();
    	Thread.sleep(5000);
    	
    	do {
    		List<WebElement> elements = driver.findElements(By.xpath("//div[@id='details']/a[@data-testid='itemDescription']"));
    				     	
        	for(WebElement rec:elements) {
        		if(rec.getText().contains("Table")) {
        			count1++;
        		}
        		else {
        			count2++;
        		}
        	}
        	if(!driver.findElement(By.xpath("//li[contains(@class,'rc-pagination-next')]/a[contains(@aria-label,'Go to page')]")).getAttribute("class").contains("disabled")) {
        		driver.findElement(By.xpath("//li[contains(@class,'rc-pagination-next')]/a[contains(@aria-label,'Go to page')]")).click();
        		
        	}	
    	}while(elementDisplayed());	
    	System.out.println(count1);
    	System.out.println(count2);
    }
    
    public void productvalidation() throws InterruptedException {
    	driver.findElement(By.xpath("//div[@id='product_listing']/div[last()]//input[@value='Add to Cart']")).click();
		
    	
    	if(driver.findElement(By.xpath("//select[@title='Countertop Edge']")).isDisplayed()) {
    		Select sel =new Select(driver.findElement(By.xpath("//select[@title='Countertop Edge']")));
    		sel.selectByVisibleText("Advance Tabco TA-12 Countertop Edge");	
    		Select sel1 =new Select(driver.findElement(By.xpath("//select[@title='Finish Upgrade']")));
    		sel1.selectByVisibleText("Advance Tabco K-350 Upgraded Finish");	
    		Select sel2 =new Select(driver.findElement(By.xpath("//select[@title='Sink Bowl']")));
    		sel2.selectByVisibleText("Advance Tabco TA-11F 10\" x 14\" Sink Bowl with Faucet, Welded into Tabletop");	
       		driver.findElement(By.xpath("//button[text()='Add To Cart']")).click();
       		Thread.sleep(3000);
       		driver.findElement(By.xpath("//a[text()='View Cart']")).click();
       		driver.findElement(By.xpath("//a[text()='Empty Cart']")).click();
       		Thread.sleep(3000);
       		driver.findElement(By.xpath("//button[text()='Empty Cart']")).click();
       		Thread.sleep(3000);
        	Assert.assertEquals(driver.findElement(By.xpath("//p[@class='header-1']")).getText(), "Your cart is empty.");
       	} 
    	
    	
    }
    public boolean elementDisplayed() {
        try {
            return driver.findElement(By.xpath("//li[contains(@class,'rc-pagination-next')]/a[contains(@aria-label,'Go to page')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    
}