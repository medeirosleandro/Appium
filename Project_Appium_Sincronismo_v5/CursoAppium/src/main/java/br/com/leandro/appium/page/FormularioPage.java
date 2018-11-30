package br.com.leandro.appium.page;

import static br.com.leandro.appium.core.DriverFactory.getDriver;

import org.openqa.selenium.By;

import br.com.leandro.appium.core.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormularioPage extends BasePage {


	public void escreverNome(String nome) {
		escrever(MobileBy.AccessibilityId("nome"), nome);
	}

	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}

	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}

	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}

	public void clicarCheck() {

		clicar(By.className("android.widget.CheckBox"));

	}

	public void clicarSwitch() {

		clicar(MobileBy.AccessibilityId("switch"));

	}

	public boolean isCheckMarcado() {

		return isCheckMarcado(By.className("android.widget.CheckBox"));

	}

	public boolean isSwitchMarcado() {

		return isCheckMarcado(MobileBy.AccessibilityId("switch"));

	}
	
	public void clicarSeekBar(double position) {
		int delta = 50;
		MobileElement seek = getDriver().findElement(MobileBy.AccessibilityId("slid"));
		int y = seek.getLocation().y + (seek.getSize().height / 2);
		System.out.println(y);
		
		int xinicial = seek.getLocation().x + delta;
		int x = (int)( xinicial + ((seek.getSize().width - 2*delta) * position));
		System.out.println(x);
		
		tap(x, y);
	}

	public void salvar() {

		clicarPortexto("SALVAR");
	}
	
	public void salvarDemorado() {

		clicarPortexto("SALVAR DEMORADO");
	}

	public String obterNomeCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Nome:')]"));

	}

	public String obterConsoleCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Console:')]"));

	}

	public String obterCheckCadastrado() {

		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Switch')]"));

	}

	public String obterSwitchCadastrado() {
		return obterTexto(By.xpath("//android.widget.TextView[starts-with(@text,'Checkbox')]"));

	}

}
