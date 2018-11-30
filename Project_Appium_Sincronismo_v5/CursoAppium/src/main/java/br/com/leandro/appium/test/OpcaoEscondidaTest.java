package br.com.leandro.appium.test;

import static br.com.leandro.appium.core.DriverFactory.getDriver;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.page.MenuPage;

public class OpcaoEscondidaTest extends BaseTest {
	
	private MenuPage menu= new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		//scroll down
		WebDriverWait wait = new WebDriverWait(getDriver(), 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Formul�rio']")));
		System.out.println("Come�ando");
		
	    menu.scrollDown();
		
		//clicar menu
		menu.clicarPortexto("Op��o bem escondida");
		
		//verificar mensagem
		Assert.assertEquals("Voc� achou essa op��o", menu.obterMensagemAlerta());
		
		//sair
		menu.clicarPortexto("OK");
		
	}

}
