package br.com.caelum.agiletickets.controllers;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import br.com.caelum.agiletickets.domain.DiretorioDeEstabelecimentos;
import br.com.caelum.agiletickets.models.Estabelecimento;

public class EstabelecimentoControllerTest {

	@Test
	public void deveListarTodosDadosDoDiretorio() {

		DiretorioDeEstabelecimentos dao = Mockito
				.mock(DiretorioDeEstabelecimentos.class);

		EstabelecimentosController sujeito = new EstabelecimentosController(
				null, null, dao);
		
		List<Estabelecimento> todos = sujeito.lista();
		
		Assert.assertEquals(Collections.EMPTY_LIST, todos);

	}

}
