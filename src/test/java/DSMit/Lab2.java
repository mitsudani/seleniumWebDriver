package DSMit;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Lab2 {

@Test
public void lab2_E0() {
	System.setProperty("webdriver.chrome.driver","C:\\_qa\\DSMit\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	// ESPERA IMPLÍCITA
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("https://www.selenium.dev/");
	WebElement linkDescarga = driver.findElement(By.linkText("Downloads"));
	linkDescarga.click();
	driver.quit();
}

@Test
public void lab2_E1() {
	System.setProperty("webdriver.chrome.driver","C:\\_qa\\DSMit\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	
	// ESPERA EXPLÍCITA
	WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
	
	// BUSQUEDA DE ELEMENTO POR NOMBRE
	WebElement txtNombre = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
    txtNombre.sendKeys("Daniela");
    
    // BÚSQUEDA DE ELEMENTO CON XPATH ABSOLUTA (NO SIRVE PARA ELEMENTOS CON ID DINÁMICO)
    // WebElement txtApellido = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\'u_0_s\']")));
    WebElement txtApellido = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("lastname")));
    txtApellido.sendKeys("Sachetti");
    
    // BÚSQUEDA DE ELEMENTO POR CSS SELECTOR
    WebElement txtCel = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='reg_email__']")));
    txtCel.sendKeys("13123");
    
    WebElement txtCont = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("reg_passwd__")));
    txtCont.sendKeys("13123");
    
    // PARA MENÚS DESPLEGABLES
    Select mes = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("month"))));
    mes.selectByVisibleText("jul");
    
    Select dia = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("day"))));
    dia.selectByIndex(4);
    
}

@Test
public void lab2_E2() {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\Mit Hydeist\\Desktop\\Tester QA\\Educación IT\\07. Testing Automation con Selenium\\DSMit\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	
	WebDriverWait myWaitVar = new WebDriverWait(driver, 10);
	
	WebElement txtMail = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("email")));
    txtMail.sendKeys("daniela@daniela.com");
    
    WebElement txtPassword = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
    txtPassword.sendKeys("12345");
    
    WebElement clickEntrar = driver.findElement(By.id("loginbutton"));
	clickEntrar.click();
	driver.quit();
}

}
