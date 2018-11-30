package br.com.leandro.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.page.AbaPage;
import br.com.leandro.appium.page.MenuPage;

public class AbaTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AbaPage page = new AbaPage();
	
	
	@Test
	public void deveInteragirComAbas() {
		//acessar menu abas
		menu.acessarAbas();
		
		//verificar que esta na aba 1
		Assert.assertTrue(page.isAba1());
		
		//acessar aba 2
		page.selecionarAba2();
		
		//verificar que esta na aba 2
		Assert.assertTrue(page.isAba2());
	}

}
