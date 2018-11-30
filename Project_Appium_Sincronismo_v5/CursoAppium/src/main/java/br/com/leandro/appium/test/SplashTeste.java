package br.com.leandro.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.page.MenuPage;
import br.com.leandro.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage(); 
	
	@Test
	public void deveAguardarSplashSumir() {
		
		//acessar menu Splash
		menu.acessarSplash();
		
		//verificar que o Splash est� sendo exibido
		page.isTelaSplashVisivel();
		
		//aguardar saida do Splash
		page.aguardarSplashSumir();
		
		//verificar que formul�rio esta aparecendo
		Assert.assertTrue(page.existeElementoPorTexto("Formul�rio"));
		
		
	}

}
