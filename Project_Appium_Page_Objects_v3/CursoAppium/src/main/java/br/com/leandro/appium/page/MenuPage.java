package br.com.leandro.appium.page;

import br.com.leandro.appium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();
	
	public void acessarFormulario() {
		dsl.clicarPortexto("Formulário");
	}

}
