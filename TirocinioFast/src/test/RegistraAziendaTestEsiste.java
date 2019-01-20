package test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistraAziendaTestEsiste {
  private WebDriver driver;
  private String baseUrl;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "/Users/Mario Greco/Desktop/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testRegistraAziendaTestEsiste() throws Exception {
    driver.get("http://localhost:8080/TirocinioFastLocale/index.jsp");
    driver.findElement(By.linkText("Registra azienda")).click();
    driver.findElement(By.name("nome")).click();
    driver.findElement(By.name("nome")).clear();
    driver.findElement(By.name("nome")).sendKeys("Informatic SRL");
    driver.findElement(By.name("iva")).clear();
    driver.findElement(By.name("iva")).sendKeys("11201436925");
    driver.findElement(By.name("ceo")).clear();
    driver.findElement(By.name("ceo")).sendKeys("Gennaro Esposito");
    driver.findElement(By.name("sede")).clear();
    driver.findElement(By.name("sede")).sendKeys("Via spaccanapoli 45, Napoli");
    driver.findElement(By.name("email")).clear();
    driver.findElement(By.name("email")).sendKeys("info@informaticsrl.it");
    driver.findElement(By.name("telefono")).clear();
    driver.findElement(By.name("telefono")).sendKeys("0815476582");
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("informaticSRL");
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("informaticSrl");
    driver.findElement(By.name("conferma")).clear();
    driver.findElement(By.name("conferma")).sendKeys("informaticSrl");
    driver.findElement(By.name("domanda")).clear();
    driver.findElement(By.name("domanda")).sendKeys("Titanic");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.id("registraAziendaButton")).click();
    driver.findElement(By.linkText("Torna alla home.")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }
}
