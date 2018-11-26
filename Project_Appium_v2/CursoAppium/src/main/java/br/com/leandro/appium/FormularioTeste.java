package br.com.leandro.appium;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.com.leandro.appium.core.DSL;
import br.com.leandro.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;

public class FormularioTeste {
	
	private DSL dsl = new DSL();


	@Before
	public void inicializarAppium() throws MalformedURLException {

		// Selecionar Formulário
		dsl.clicarPortexto("Formulário");
		
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}

	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {
		// Escrever nome
		dsl.escrever(MobileBy.AccessibilityId("nome"),"Leandro");

		// Checar nome escrito
		assertEquals("Leandro", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}

	@Test
	public void deveInteragirCombo() throws MalformedURLException {
		// Clicar no Combo
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");

		// Verificar opção selecionada
		String text = dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
		Assert.assertEquals("Nintendo Switch", text);

	}

	@Test
	public void deveInteragirSwitchCheckBox() throws MalformedURLException {
		// verificar status dos elementos
		Assert.assertFalse(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertTrue(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

		// clicar nos elementos
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(MobileBy.AccessibilityId("switch"));

		// verificar estados alterados
		Assert.assertTrue(dsl.isCheckMarcado(By.className("android.widget.CheckBox")));
		Assert.assertFalse(dsl.isCheckMarcado(MobileBy.AccessibilityId("switch")));

	}

	@Test
	public void deverRealizarCadastro() throws MalformedURLException {
		// preencher campos
		dsl.escrever(By.className("android.widget.EditText"),"Leandro");
		dsl.clicar(By.className("android.widget.CheckBox"));
		dsl.clicar(By.className("android.widget.Switch"));
		dsl.selecionarCombo(By.className("android.widget.Spinner"),"Nintendo Switch");

		// salvar
		dsl.clicarPortexto("SALVAR");

		// verificacao
		Assert.assertEquals("Nome: Leandro",dsl.obterTexto(By.xpath("//android.widget.TextView[@text='Nome: Leandro']")));

		Assert.assertEquals("Console: switch", dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]")));

		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch')]")).endsWith("Off"));

		Assert.assertTrue(dsl.obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox')]")).endsWith("Marcado"));

	}

}
