package Pruebas;

import org.testng.annotations.Test;
import org.testng.annotations.*;
import Paginas.paginaInicio;
import Paginas.paginaLogin;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

public class Laboratorio3_E2 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String pathDriver = "C:\\_qa\\DSMit\\Drivers\\chromedriver.exe";

	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", pathDriver);
		driver = new ChromeDriver();
		driver.get(url);
	}

	@Test (priority=0)
	public void f() {
		paginaInicio inicio = new paginaInicio(driver);
		inicio.clicLogin();
	}
	
	@Test (priority=1)
	public void ingreso() throws IOException {
		paginaLogin login = new paginaLogin(driver);
		login.loginUsuario("dasdad", "asdasds");
	
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\DSMit\\Evidencias\\Test.png"));
	}

}
