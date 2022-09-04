package br.edu.uea.pp.iu;

import java.util.ArrayList;

import br.edu.uea.pp.negocio.ContaCorrente;
import br.edu.uea.pp.negocio.Transacao;

public class CaixaEletronico { // Questão 2 - a)
	
	private static String formatarDinheiro(float valor) {
		return String.format("R$%.2f", valor);
	}
	
	public static void main(String[] args) { 
		ContaCorrente contaCorrente = new ContaCorrente(123456789, 001); // Questão 2 - b) TODO Instanciar também a classe Cliente
		contaCorrente.depositar(1200); // Questão  2 - c
		contaCorrente.sacar(200); // Questão 2 - d
		
		
		ArrayList<Transacao> extrato = contaCorrente.getExtrato(); // Questão 2 - f)
		System.out.println("======= CONTA CORRENTE =======");
		System.out.println("| AGÊNCIA: " + contaCorrente.getNumeroAgencia() 
		+ "\n| NÚMERO DA CONTA: " + contaCorrente.getNumeroConta() 
		+ "\n| SALDO ATUAL: R$" + contaCorrente.getSaldo()+ "\n");
		if(extrato.isEmpty()) {
			System.out.println("Nenhuma transação realizada no momento.");
		}else {
			for(Transacao transacao : extrato) {
				System.out.println(
						"> [" + 
						transacao.getOperacao() + 
						"] Transação realizada no dia " + 
						transacao.getDataHora() + 
						" no valor de " + 
						CaixaEletronico.formatarDinheiro(transacao.getValor())
				);
			}
		}
	}
}
