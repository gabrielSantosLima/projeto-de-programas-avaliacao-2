package br.edu.uea.pp.negocio;

public class Transacao {
	private String operacao;
	private float valor;
	private String dataHora;
	private float saldo;
	
	public Transacao(float saldo, String operacao, float valor, String dataHora) {
		this.saldo = saldo;
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

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}
