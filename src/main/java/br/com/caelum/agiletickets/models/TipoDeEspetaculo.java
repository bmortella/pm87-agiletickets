package br.com.caelum.agiletickets.models;

import java.math.BigDecimal;

public enum TipoDeEspetaculo {

	CINEMA {
		@Override
		public BigDecimal calcula(int quantidade, Sessao sessao) {
			return calculaCinemaEShow(sessao);
		}
	},
	SHOW {
		public BigDecimal calcula(int quantidade, Sessao sessao) {
			return calculaCinemaEShow(sessao);
		}
	},
	TEATRO {
		@Override
		public BigDecimal calcula(int quantidade, Sessao sessao) {
			return sessao.getPreco();
		}
	},
	BALLET {
		@Override
		public BigDecimal calcula(int quantidade, Sessao sessao) {
			return calculaBalletEOrquestra(sessao);
		}
	},
	ORQUESTRA {
		@Override
		public BigDecimal calcula(int quantidade, Sessao sessao) {
			return calculaBalletEOrquestra(sessao);
		}
	};

	private static BigDecimal calculaCinemaEShow(Sessao sessao) {
		BigDecimal preco;
		if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.05) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		} else {
			preco = sessao.getPreco();
		}
		return preco;
	}

	private static BigDecimal calculaBalletEOrquestra(Sessao sessao) {
		BigDecimal preco;
		if((sessao.getTotalIngressos() - sessao.getIngressosReservados()) / sessao.getTotalIngressos().doubleValue() <= 0.50) { 
			preco = sessao.getPreco().add(sessao.getPreco().multiply(BigDecimal.valueOf(0.20)));
		} else {
			preco = sessao.getPreco();
		}
		
		if(sessao.getDuracaoEmMinutos() > 60){
			preco = preco.add(sessao.getPreco().multiply(BigDecimal.valueOf(0.10)));
		}
		return preco;
	}

	public abstract BigDecimal calcula(int quantidade, Sessao sessao);

}
