package br.com.leandro.appium.test;

import org.apache.http.impl.bootstrap.SSLServerSetupHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.page.CliquesPage;
import br.com.leandro.appium.page.MenuPage;

public class CliqueTeste extends BaseTest {
	
	private MenuPage  menu = new MenuPage();
	private CliquesPage page = new CliquesPage();
	
	@Before
	public void setup() {
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		//clique longo
		page.cliqueLongo();
		
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPortexto("Clique duplo");
		page.clicarPortexto("Clique duplo");
		
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}
}
