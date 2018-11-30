package br.com.leandro.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.page.MenuPage;

public class SwipeTest extends BaseTest {
	
	private MenuPage menu = new MenuPage(); 
	
	@Test
	public void deveRealizarSwipe() {
		
		//acessar menu
		menu.acessarSwipe();
		
		//verificar texto "a esquerda"
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		//swipe para direita
		menu.swipeRight();;
		
		//verificar texto 'E veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		
		//clicar botão direita
		menu.clicarPortexto("›");
		
		//verificar texto 'Chegar até o fim'
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		
		//swipe esquerda
		menu.swipeLeft();;
		
		//clicar no botão esquerda
		menu.clicarPortexto("‹");
		
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
		
		
	}

}
