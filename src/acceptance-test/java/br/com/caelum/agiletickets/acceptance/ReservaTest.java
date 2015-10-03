package br.com.caelum.agiletickets.acceptance;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReservaTest {
	private static WebDriver browser;
	private static final String BASE_URL = "http://localhost:8080";

	@Before
	public void setUp() throws Exception {
		browser = new FirefoxDriver();
	}

	@After
	public void teardown() {
		browser.close();
	}

	@Test
	public void reservaIngressoEChecaAcrescimo() throws InterruptedException {
		browser.get(BASE_URL + "/sessao/6");
		browser.findElement(By.name("quantidade")).sendKeys("1");
		WebElement div = browser.findElement(By.id("content"));
		WebElement form = div.findElement(By.tagName("form"));
		form.submit();
		WebElement mensagem = browser.findElement(By.id("message"));
		assertThat(mensagem.getText(), containsString("Sessão reservada com sucesso por R$ 55,00"));
	}
	
}
