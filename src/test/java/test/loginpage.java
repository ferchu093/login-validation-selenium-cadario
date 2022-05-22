package test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class loginpage {
	//VARIABLES
	private WebDriver driver;
	private static final String TIPO_DRIVER = "webdriver.chrome.driver";
	private static final String PATH_DRIVER = "./src/test/resources/webDriver/chromedriver.exe";
	private String URL = "https://online-testing.com/Account/Login";
	
	@BeforeClass
	public static void setUpBeforeClass()
	{
		System.out.println("INICIO DE TESTS");
		System.setProperty(TIPO_DRIVER, PATH_DRIVER);
	}
	@Before
	public void setUp()
	{
		//Abre el navegador
		driver = new ChromeDriver();
		driver.get(URL);
	}
	@Test
	public void testSourch()
	{
		driver.findElement(By.name("ctl00$MainContent$Username")).sendKeys("user");
		driver.findElement(By.name("ctl00$MainContent$Password")).sendKeys("pass");
		driver.findElement(By.name("ctl00$MainContent$ctl04")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			//TODO auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"loginForm\"]/div/div[2]/div/span")).getText().contains("Error"));
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterClass
	public static void tearDownAfterClass()
	{
		System.out.println("FINALIZARON LOS TESTS");
	}
	
	

}
