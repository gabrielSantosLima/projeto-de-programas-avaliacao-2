package br.edu.uea.pp.negocio;

public class ContaCorrente {
	private float saldo;
	private int numeroConta;
	private int numeroAgencia;
	
	public ContaCorrente(float saldo, int numeroConta, int numeroAgencia) {
		this.saldo = saldo;
		this.numeroConta = numeroConta;
		this.numeroAgencia = numeroAgencia;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}
}
