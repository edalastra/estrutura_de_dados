package app;

import java.util.Random;
import java.util.Scanner;

import models.Nodo;
import models.Pnd;

import javax.swing.*;


public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o tamanho da lista: ");
		
		try {
			Pnd pnd = new Pnd(input.nextInt());
			System.out.println("Adicionando dados a lista...");
			for(int i = 0; i < pnd.getLista().length - 1; i++) {
				Random gerador = new Random();
				pnd.inclusao(gerador.nextInt(50) + 1);
				System.out.println(pnd.saida());

			}
			System.out.println("Maior elemento da PND >> " + pnd.maiorElemento());
			System.out.println("Menor elemento da PND >> " + pnd.menorElemento());
			System.out.println("Media dos elementos da PND >> " + pnd.media());
			
		} catch (RuntimeException e) {
			System.out.println(e.getLocalizedMessage());
		}

	}

}
