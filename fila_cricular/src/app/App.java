package app;

import java.util.Random;
import java.util.Scanner;

import models.FilaCircular;

public class App {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		FilaCircular f1 = new FilaCircular(input.nextInt());
		FilaCircular f2 = new FilaCircular(input.nextInt());
		
		try {
		for (int i = 0; i < 50; i++) {
			System.out.print("Digite um numero: ");
			int num = input.nextInt();
			if(num % 2 == 0) {
				 Random random = new Random();
			     f1.inclusao(random.nextInt((120 - 50) + 1) + 50); 
			} else {
				f2.inclusao(num);
				if(f1.isVazia())
					f1.retirada();
			}
			f1.imprime();
			f2.imprime();
		}
		
		
		} catch (RuntimeException e) {
			System.out.println(e.getMessage() + ". Programa finalizado");
		}
		
	}
}
