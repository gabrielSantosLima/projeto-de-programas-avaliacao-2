package br.edu.uea.pp.iu;

import java.util.ArrayList;

import br.edu.uea.pp.negocio.Cliente;
import br.edu.uea.pp.negocio.ContaCorrente;
import br.edu.uea.pp.negocio.Transacao;

public class CaixaEletronico { // Questão 2 - a)
	
	private static String formatarDinheiro(float valor) {
		return String.format("R$%.2f", valor);
	}
	
	public static void main(String[] args) { 
		ContaCorrente contaCorrente = new ContaCorrente(123456789, 001); // Questão 2 - b
		Cliente cliente = new Cliente("Melinne", "3178372-0", "Rua Luz do Sol, 132", contaCorrente); // Questão 2 - b
		cliente.getContaCorrente().depositar(1200); // Questão  2 - c
		cliente.getContaCorrente().sacar(200); // Questão 2 - d
		
		
		ArrayList<Transacao> extrato = contaCorrente.getExtrato(); // Questão 2 - f)
		System.out.println("======= CONTA CORRENTE =======");
		System.out.println("| AGÊNCIA: " + cliente.getContaCorrente().getNumeroAgencia() 
		+ "\n| NÚMERO DA CONTA: " + cliente.getContaCorrente().getNumeroConta() 
		+ "\n| SALDO ATUAL: R$" + cliente.getContaCorrente().getSaldo()+ "\n");
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
