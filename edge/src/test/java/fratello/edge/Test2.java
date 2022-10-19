package fratello.edge;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2  {

	WebDriver driver = null;
	
	@BeforeTest
	public void open_edgeDriver()
	{
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void open_swiggy() {
		String expected_title = "Order food online from India's best food delivery service. Order from restaurants near you";
		driver.get("http://www.swiggy.com/");
		verify (expected_title);
		}
	
	@Test
	public void open_zomato() { 
		String expected_title = "Zomato";
		driver.get("http://www.zomato.com/");
		verify (expected_title);}
	 
	@Test
	public void open_abhibus() 
	{
		String expected_title = "Book Bus Tickets Online at Lowest Fare, Flat ₹500 Cashback On Bus Booking | AbhiBus";
		driver.get("http://www.abhibus.com/");
		verify (expected_title);
		}
	@AfterTest
	public void close_browser() throws InterruptedException 
	{
	Thread.sleep(3000);
	driver.close();}
	       
	public void verify (String expected_title) {
		String actual_title = driver.getTitle();
		System.out.println(driver.getTitle());
		Assert.assertEquals(expected_title,  actual_title);
	}		
	}

