package DSMit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Lab1 {
@Ignore
public void lab1_E1() { // lab1_E1 laboratorio 1 ejercicio 1 
	System.setProperty("webdriver.chrome.driver","C:\\_qa\\DSMit\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://selenium.dev/");
	driver.quit();
}

// lab1_E2 es lo mismo pero con FireFox

@Ignore
public void lab1_E2() {
	System.setProperty("webdriver.chrome.driver","C:\\_qa\\DSMit\\Drivers\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://selenium.dev/");
	driver.manage().window().maximize();
	driver.quit();
}

@Test
public void lab1_E3() {
	System.setProperty("webdriver.chrome.driver","C:\\_qa\\DSMit\\Driverschromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://selenium.dev/");
	WebElement txtBusqueda= driver.findElement(By.id("gsc-i-id1"));
	txtBusqueda.sendKeys("busqueda");
	txtBusqueda.sendKeys(Keys.ENTER);
	driver.quit();
}

}









