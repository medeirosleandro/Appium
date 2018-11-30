package br.com.leandro.appium.core;

import static br.com.leandro.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {
	
	public void escrever(By by, String texto) {
		getDriver().findElement(by).sendKeys(texto);
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void clicar(By by) {
		getDriver().findElement(by).click();

	}

	public void clicarPortexto(String texto) {
		clicar(By.xpath("//*[@text='" + texto + "']"));
	}

	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPortexto(valor);
	}

	public boolean isCheckMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}
	
	public boolean existeElementoPorTexto (String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}
	
	public String obterTituloAlerta() {

		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String obterMensagemAlerta() {

		return obterTexto(By.id("android:id/message"));

	}
	
	public void tap(int x, int y) {
		
		new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
		
	}
	
	public void scrollDown() {
		scroll(0.9,  0.1);
	}
	
	public void scrollUp() {
		scroll(0.1,  0.9);
	}
	
	public void swipeLeft() {
		swipe(0.1, 0.9);
	}
	
	public void swipeRight() {
		swipe(0.9, 0.1);
	} 
	
	public void scroll (double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int x = size.width/2;
		
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		
		new TouchAction(getDriver())
		.press(PointOption.point(x,start_y ))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
		.moveTo(PointOption.point(x,end_y))
		.release()
		.perform();
	}
	
	public void swipe(double inicio, double fim) {
		Dimension size = getDriver().manage().window().getSize();
		
		int y = size.height /2;
		
		int start_x = (int) (size.width * inicio);
		int end_x = (int) (size.width * fim);
		
		new TouchAction(getDriver())
		.press(PointOption.point(start_x,y))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
		.moveTo(PointOption.point(end_x,y))
		.release()
		.perform();
		
	}
	
	public void swipeElement(MobileElement element, double inicio, double fim) {
		
		int y = element.getLocation().y +(element.getSize().height / 2);
		
		int start_x = (int) (element.getSize().width * inicio);
		int end_x = (int) (element.getSize().width * fim);
		
		new TouchAction(getDriver())
		.press(PointOption.point(start_x,y))
		.waitAction(new WaitOptions().withDuration(Duration.ofMillis(500)))
		.moveTo(PointOption.point(end_x,y))
		.release()
		.perform();
		
	}
}
