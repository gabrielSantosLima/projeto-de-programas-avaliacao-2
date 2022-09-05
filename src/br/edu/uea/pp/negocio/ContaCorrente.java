package br.edu.uea.pp.negocio;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ContaCorrente {
	private float saldo;
	private int numeroConta;
	private int numeroAgencia;
	private ArrayList<Transacao> transacoes; // Questão 1 - a)
	
	public ContaCorrente(int numeroConta, int numeroAgencia) {
		this.saldo = 0.0f; // Questão 1 - b)
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
		this.transacoes = new ArrayList<>();
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
	
	public void depositar(float v) // Questão 1 - d
	{
		this.saldo += v;
		String dataAtual = getDataAtualComoTexto();
		Transacao transacao = new Transacao("depósito", v, dataAtual);
		registrarTransacao(transacao);
	}
	
	public boolean sacar(float v) { // Questão 1 - e)
		float saldoAtual = getSaldo();
		if(saldoAtual - v >= 0.0f) {
			setSaldo(saldoAtual - v);
			String dataAtual = getDataAtualComoTexto();
			Transacao transacaoRealizada = new Transacao("Saque", v, dataAtual);
			registrarTransacao(transacaoRealizada);
			return true;
		}
		return false;
	}
	
	public ArrayList<Transacao> getExtrato() { // Questão 1 - f)
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
	
}
