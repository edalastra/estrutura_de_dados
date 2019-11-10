package app;

import java.util.Scanner;

import models.Pnd;

public class App {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		estrutura_de_dados
		System.out.print("Digite o tamanho da lista: ");
		int tam = input.nextInt();
		try {
			Pnd pnd = new Pnd(tam);
		
		
		
		int sair = 0;
		
		while(sair == 0) {
			System.out.println("Voc� deseja: ");
			System.out.println("    Inserir um elemento na lista - 1");
			System.out.println("    Retirar um elemento na lista - 2");
			System.out.println("    Finalizar o programa - 3");
			System.out.print(">> ");
			int opc = input.nextInt();
			
			switch (opc) {
			case 1:
					System.out.print("Digite o valor a ser inserido: ");
					int inclui = input.nextInt();
					pnd.inclusao(inclui);
					pnd.imprime();
				break ;
			case 2:
					System.out.print("Digite o valor a ser retirado: ");
					int retira = input.nextInt();
					pnd.retirada(retira);
					pnd.imprime();
				break;
			case 3: 
					sair = 1;
				break;
			default:
	
				System.out.println("Op��o inv�lida. Digite novamente");
			}
		}
		
		} catch(RuntimeException e) {
			System.out.println(e.getMessage() + " Programa finalizado");
		}
	}
	
	
}
