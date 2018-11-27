package br.com.leandro.appium.test;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.core.DriverFactory;
import br.com.leandro.appium.page.FormularioPage;
import br.com.leandro.appium.page.MenuPage;

public class FormularioTeste extends BaseTest{

	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();

	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();

	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		
		page.escreverNome("Leandro");
		assertEquals("Leandro", page.obterNome());
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		page.selecionarCombo("Nintendo Switch");
		Assert.assertEquals("Nintendo Switch", page.obterValorCombo());

	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// verificar status dos elementos
		Assert.assertFalse(page.isCheckMarcado());
		Assert.assertTrue(page.isSwitchMarcado());

		page.clicarCheck();
		page.clicarSwitch();

		Assert.assertTrue(page.isCheckMarcado());
		Assert.assertFalse(page.isSwitchMarcado());

	}

	@Test
	public void deverRealizarCadastro() throws MalformedURLException {
		page.escreverNome("Leandro");
		page.clicarCheck();
		page.clicarSwitch();
		page.selecionarCombo("Nintendo Switch");
		
		page.salvar();

		Assert.assertEquals("Nome: Leandro", page.obterNomeCadastrado());
		Assert.assertEquals("Console: switch", page.obterConsoleCadastrado());
		Assert.assertTrue(page.obterCheckCadastrado().endsWith("Off"));
		Assert.assertTrue(page.obterSwitchCadastrado().endsWith("Marcado"));

	}
	
	@Test
	public void deverRealizarCadastroDemorado() throws MalformedURLException {
		page.escreverNome("Leandro");
		
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		page.salvarDemorado();
		//esperar(5000);
		
		
		//Utilize o Wait caso o implicit não resolva no caso de aplicações mobile
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(),10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Nome: Leandro']")));

		Assert.assertEquals("Nome: Leandro", page.obterNomeCadastrado());

	}

}
