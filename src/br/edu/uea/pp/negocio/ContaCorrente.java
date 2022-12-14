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
		Transacao transacao = new Transacao(this.getSaldo(),"Depósito", v, dataAtual);
		registrarTransacao(transacao);
	}
	
	/* Questão 1 - e)
	 * 
	 * No método sacar, é verificado se há a possilidade de saque com o valor passado por parâmetro.
	 * Caso seja possível, o valor é descontado do saldo atual e uma transação é registrada.
	 * */
	public boolean sacar(float v) {
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
	 * A função extrato retorna todos os itens da lista de transações realizadas.
	 */
	public ArrayList<Transacao> getExtrato() {
		return this.transacoes;
	}
	
	/* Questão 1 - c)
	 * 
	 * No método registrarTansacao, adicionamos a instância de uma nova transação 
	 * a lista de transações da conta corrente atual.
	 * */
	private void registrarTransacao(Transacao transacao) { 
		ArrayList<Transacao> transacoesAtuais = getExtrato();
		transacoesAtuais.add(transacao);
	}
	
	// Método auxiliar que retorna data no formato padrão pt-BR.
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
