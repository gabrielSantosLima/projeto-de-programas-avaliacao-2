package br.edu.uea.pp.iu;

import java.util.ArrayList;

import br.edu.uea.pp.negocio.ContaCorrente;
import br.edu.uea.pp.negocio.Transacao;
import br.edu.uea.pp.negocio.Cliente;


public class CaixaEletronico { // Questão 2 - a)
	
	private static String formatarDinheiro(float valor) {
		return String.format("R$%.2f", valor);
	}
	
	public static void main(String[] args) { 
		Cliente cliente1 = new Cliente("Fatima", "3178372-0", "Rua Luz do Sol, 132"); // Questão 2 - b
		ContaCorrente contaCorrente = new ContaCorrente(123456789, 001, cliente1); // Questão 2 - b
		contaCorrente.depositar(1200); // Questão  2 - c
		contaCorrente.sacar(200); // Questão 2 - d
		
		
		ArrayList<Transacao> extrato = contaCorrente.getExtrato(); // Questão 2 - f)
		System.out.println("======= CONTA CORRENTE =======");
		System.out.println("| AGÊNCIA: " + contaCorrente.getNumeroAgencia() 
		+ "\n| NÚMERO DA CONTA: " + contaCorrente.getNumeroConta() 
		+ "\n| SALDO ATUAL: R$" + contaCorrente.getSaldo()
		+ "\n| CLIENTE: " + contaCorrente.getCliente().getNome()+ "\n");
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
