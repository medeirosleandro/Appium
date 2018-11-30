package br.com.leandro.appium.page;

import static br.com.leandro.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.leandro.appium.core.BasePage;

public class MenuPage extends BasePage {
	
	
	public void acessarFormulario() {
		clicarPortexto("Formulário");
	}
	
	public void acessarSplash() {
		clicarPortexto("Splash");
	}
	
	public void acessarAlertas() {
		clicarPortexto("Alertas");
	}
	
	public void acessarAbas() {
		clicarPortexto("Abas");
	}
	
	public void acessarAccordion() {
		clicarPortexto("Accordion");
	}
	
	public void acessarCliques() {
		clicarPortexto("Cliques");
	}
	
	public void acessarSwipe() {
		clicarPortexto("Swipe");
	}
	
	public void clicarSwipeList() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
	    scrollDown();
	    clicarPortexto("Swipe List");
	}
	
	public void clicarDragNDrop() {
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formulário']")));
	    scrollDown();
	    clicarPortexto("Drag and drop");
	}

}
