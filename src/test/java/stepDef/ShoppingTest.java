package stepDef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ShoppingTest {
	
	public static WebDriver driver;
	public static String URL = "http://automationpractice.com/index.php";
	
	
	
	@Before
	
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));

	}
	
	@Given("^I can open the shopping site$")
	public void i_can_open_the_shopping_site() {
		
		driver.get(URL);
		assertEquals("My Store", driver.getTitle());
		

	}

	@When("^I search for a dress$")
	public void i_search_for_a_dress() {
	    
		driver.findElement(By.id("search_query_top")).sendKeys("dress");
		driver.findElement(By.cssSelector("ajax_block_product:nth-child(1) .replace-2x")).click();
		driver.findElement(By.cssSelector("h1"));
		driver.findElement(By.cssSelector(".product_img_link")).click();
	    
	}

	@Then("^I can add it to my cart$")
	public void i_can_add_it_to_my_cart() throws Throwable {
		driver.findElement(By.xpath("/html/body/div/div[2]/div/div[4]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")).click();
		Thread.sleep(2000);
		
	}
	
	 @After
	  public void tearDown() {
	    driver.quit();
	  }


}
