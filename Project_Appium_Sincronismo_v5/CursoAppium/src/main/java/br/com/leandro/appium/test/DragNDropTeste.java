package br.com.leandro.appium.test;

import java.awt.print.Pageable;

import org.junit.Assert;
import org.junit.Test;

import br.com.leandro.appium.core.BaseTest;
import br.com.leandro.appium.page.DragDropPage;
import br.com.leandro.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragDropPage page = new DragDropPage();
	private String [] estadoInicial = new String [] {"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."};
	private String [] estadoIntermediario = new String [] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String [] estadoFinal = new String [] {"Fa�a um clique longo", "� uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};
	
	@Test
	public void deveEfetuarDragNDrop() {
		//Acessar Menu
		menu.clicarDragNDrop();
		
		//verificar estado inicial
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial,page.obterLista() );
		
		//arrastar "Esta" para "e arraste para"
		page.arrastar("Esta","e arraste para");
		
		
		//verificar estado intermedi�rio
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		
		//arrastar "Fa�a um clique longo," para "� uma lista"
		page.arrastar("Fa�a um clique longo", "� uma lista");
		
		//Verificar estado final
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
		
		
	}

}
