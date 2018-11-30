package br.com.leandro.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.page.AccordionPage;
import br.com.leandro.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage(); 
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveIntergirComAccordion() {
		//acessar menu
		menu.acessarAccordion();
		
		//clicar op 1
		page.selecionarOp1();
		
		//verificar text op 1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
		
	}
	
}
