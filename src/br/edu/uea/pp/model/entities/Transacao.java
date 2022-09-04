package br.edu.uea.pp.model.entities;

public class Transacao {
	private String operacao;
	private float valor;
	private String dataHora;
	
	public Transacao(String operacao, float valor, String dataHora) {
		this.operacao = operacao;
		this.valor = valor;
		this.dataHora = dataHora;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
}
