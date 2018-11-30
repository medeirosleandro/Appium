package br.com.leandro.appium.core;

import org.openqa.selenium.By;

public class AlertPage extends BasePage {

	public void clicarAlertaConfirm() {

		clicarPortexto("ALERTA CONFIRM");
	}
	
	public void clicarAlertaSimples() {
		clicarPortexto("ALERTA SIMPLES");
	}
	
	public void confirmar() {
		clicarPortexto("CONFIRMAR");
	}
	
	public void sair() {
		clicarPortexto("SAIR");
	}
	
	public void clicarForaCaixa() {
		tap(100,150);
	}
}
