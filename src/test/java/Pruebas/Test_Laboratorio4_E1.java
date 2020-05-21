package Pruebas;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Paginas.paginaInicio;
import Paginas.paginaLogin;
import Utilidades.DatosExcel;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.DataProvider;
import org.testng.Assert;

public class Test_Laboratorio4_E1 {
	WebDriver driver;
	String url = "http://automationpractice.com/index.php";
	String pathDriver = "C:\\_qa\\DSMit\\Drivers\\chromedriver.exe";

	@BeforeSuite
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
	
	@Test (priority=1, dataProvider="Registro Invalido Excel")
	public void ingreso(String usuario, String clave) throws IOException {
		paginaLogin login = new paginaLogin(driver);
		login.loginUsuario(usuario, clave);
	
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\DSMit\\Evidencias\\Test.png"));
	
		Assert.assertEquals("AUTHENTICATION", login.getTituloForm());
	}
	
	@DataProvider (name="Registro Invalido")
	public Object[][] dp() {
		Object[][] datos = new Object[2][2];
		 datos[0][0]="nadia";
	     datos[0][1]="contrasda";
	     datos[1][0]="pedro";
	     datos[1][1]="12311";
	        
	     return datos;
	    }

	@DataProvider (name="Registro Invalido Excel")
	public Object[][] datosPruebaExcel() throws Exception {
		Object[][] datos = DatosExcel.leerExcel("C:\\_qa\\DSMit\\Recursos\\datos.xlsx", "Hoja1");
		return datos;
	}
	
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	
}
