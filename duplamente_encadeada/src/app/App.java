package app;

import java.util.Random;
import java.util.Scanner;

import models.Nodo;
import models.Pnd;



public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o tamanho da lista: ");
		
		try {
			Pnd pnd = new Pnd(input.nextInt());
			for(int i = 0; i < pnd.getLista().length; i++) {
				Random gerador = new Random();
				pnd.inclusao(gerador.nextInt());
			}
			
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		// Insere numeros aleatórios na lista
		
		
	}
}
