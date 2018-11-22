package br.com.leandro.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class FormularioTeste {

	@Test
	public void deveInstalarAPK() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");


		//Instalando o APK via Appium
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\lmedeiros\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar Formulário
		
		List<MobileElement> elementosEncontrados = driver.findElements(By.className("android.widget.TextView"));
		//for(MobileElement elemento:elementosEncontrados ) {
		//	System.out.println(elemento.getText());
		//}
		
		elementosEncontrados.get(1).click();
		
		//Escrever nome
	
		MobileElement campoNome= driver.findElement(MobileBy.AccessibilityId("nome"));
		campoNome.sendKeys("Leandro");
		
		//Checar nome escrito
		String text = campoNome.getText();
		Assert.assertEquals("Leandro", text);

		driver.quit();
	}
	
	@Test
	public void deveInteragirCombo() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");


		//Instalando o APK via Appium
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\lmedeiros\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar Formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//Clicar no Combo
		driver.findElement(MobileBy.AccessibilityId("console")).click();
		
		//Selecionar opção desejada
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();
		
		//Verificar opção selecionada
		String text = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
		Assert.assertEquals("Nintendo Switch", text);

		driver.quit();
	}
	
	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");


		//Instalando o APK via Appium
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\lmedeiros\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar Formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//verificar status dos elementos
		MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
		MobileElement switc = driver.findElement(MobileBy.AccessibilityId("switch"));
		Assert.assertTrue(check.getAttribute("checked").equals("false"));
		Assert.assertTrue(switc.getAttribute("checked").equals("true"));
		
		//clicar nos elementos
		check.click();
		switc.click();
		
		//verificar estados alterados
		Assert.assertFalse(check.getAttribute("checked").equals("false"));
		Assert.assertFalse(switc.getAttribute("checked").equals("true"));

		driver.quit();
	}
	
	@Test
	public void desafio() throws MalformedURLException {

		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setCapability("platformName", "Android");
		desiredCapabilities.setCapability("deviceName", "emulator-5554");
		desiredCapabilities.setCapability("automationName", "uiautomator2");


		//Instalando o APK via Appium
		desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\lmedeiros\\eclipse-workspace\\CursoAppium\\src\\main\\resources\\CTAppium-1-1.apk");

		AndroidDriver<MobileElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Selecionar Formulário
		driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
		
		//preencher campos
		driver.findElement(By.className("android.widget.EditText")).sendKeys("TIRULIPA");
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.className("android.widget.Switch")).click();
		driver.findElement(By.className("android.widget.Spinner")).click();
		driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='XBox One']")).click();
		
		//salvar
		driver.findElement(By.xpath("//*[@text='SALVAR']")).click();
		
		//verificacao
		MobileElement nome = driver.findElement(By.xpath("//android.widget.TextView[@text='Nome: TIRULIPA']"));
		Assert.assertEquals("Nome: TIRULIPA",nome.getText());
		
		//Spinner
		MobileElement combo = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]"));
		Assert.assertEquals("Console: xone", combo.getText());
		
		//Switch (Chave seletora)
		MobileElement swit = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Switch')]"));
		Assert.assertTrue(swit.getText().endsWith("Off"));
		
		//CheckBox
		MobileElement check = driver.findElement(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox')]"));
		Assert.assertTrue(check.getText().endsWith("Marcado"));


		
		driver.quit();
	}

}
