package br.edu.uea.pp.negocio;

import java.text.DateFormat;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ContaCorrente {
	private float saldo;
	private int numeroConta;
	private int numeroAgencia;
	private ArrayList<Transacao> transacoes; // Questão 1 - a)
	private Cliente cliente;

	public ContaCorrente(int numeroConta, int numeroAgencia, Cliente cliente) {
		this.saldo = 0.0f; // Questão 1 - b) 

		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.transacoes = new ArrayList<>();
		this.setCliente(cliente);
	}

	public float getSaldo() { // Questão 1 - g)
		return saldo;
	}

	public int getNumeroConta() { // Questão 1 - g)
		return numeroConta;
	}

	public int getNumeroAgencia() { // Questão 1 - g)
		return numeroAgencia;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	/* Questão 1 - d)
	 * 
	 * No método depositar, para evitar que desconte ao invés 
	 * de adicionar, utilizamos o "módulo" do Java da biblioteca Math.
	 * */
	
	public void depositar(float v) 
	{
		this.saldo += Math.abs(v);
		String dataAtual = getDataAtualComoTexto();
		Transacao transacao = new Transacao(this.getSaldo(),"depósito", v, dataAtual);
		registrarTransacao(transacao);
	}
	
	public boolean sacar(float v) { // Questão 1 - e)
		float saldoAtual = getSaldo();
		if(saldoAtual - v >= 0.0f) {
			setSaldo(saldoAtual - v);
			String dataAtual = getDataAtualComoTexto();
			Transacao transacaoRealizada = new Transacao(this.getSaldo(), "Saque", v, dataAtual);
			registrarTransacao(transacaoRealizada);
			return true;
		}
		return false;
	}
	
	/* Questão 1 - f)
	 * 
	 * A função extrato retorna todos os itens da lista de transações realizadas
	 * 
	 */
	
	public ArrayList<Transacao> getExtrato() {
		return this.transacoes;
	}
	
	private void registrarTransacao(Transacao transacao) { // Questão 1 - c)
		ArrayList<Transacao> transacoesAtuais = getExtrato();
		transacoesAtuais.add(transacao);
	}
	
	private String getDataAtualComoTexto() {
		Locale local = new Locale("pt", "BR");
		DateFormat formatadorDeData = DateFormat.getDateInstance(DateFormat.DEFAULT, local);
		return formatadorDeData.format(new Date());
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
