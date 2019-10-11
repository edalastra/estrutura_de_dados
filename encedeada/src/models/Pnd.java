package models;

import javax.management.RuntimeErrorException;

public class Pnd {
	private int disp, nc, tamanho;
	private Nodo lista[];
	
	public Pnd(int tamanho) throws RuntimeException {
		this.tamanho = tamanho;
		this.lista = new Nodo[tamanho];
		this.criaPnd();
		this.criaNc();
	}
	
	private void criaPnd() {
		
		 int i = 0;
		 while ( i < this.tamanho  ){
			this.lista[i] = new Nodo(i+1);
			i++;
		 }
		 this.lista[ this.tamanho -1 ].elo = -1;
		 this.disp = 0;
	}
	
	private void criaNc() throws RuntimeException {
	 this.nc = this.obtem();
	 if ( nc == -1 ){
		 throw new RuntimeException("Não é possivel criar o Nodo Cabeça. Programa encerrado");
	 }
	 this.lista[ nc ].info = -1;

	 this.lista[ nc ].elo = -1;
	}

	private int obtem() {
		int aux;
		 if ( disp == -1 )
			 return( -1 );
		 aux = disp;
		 disp = lista[ disp ].elo;
		 return aux ;
	}
	
	private void libera(int indice) {
	 this.lista[ indice ].elo = this.disp;
	 this.disp = indice;
	}
	
	public void inclusao(int valor ) throws RuntimeException {
	 int post, ant, indice;
	 indice = this.obtem();
	 if ( indice == -1 )
		 throw new RuntimeException("Overflow");
	 else {
		 this.lista[ indice ].info = valor;
		 ant = this.nc;
		 post = this.lista[ this.nc ].elo;
		 while( post != -1 ) {
			 if ( valor < this.lista[ post ].info ) 
				 break;
			ant = post;
			post = this.lista[ post ].elo;
		}
		 this.lista[ indice ].elo = post;
		 this.lista[ ant ].elo = indice;
		 if ( post == -1 )
			 lista[ nc ].info = indice; 
	 }
	}

	public void retirada( int valor ) throws RuntimeException{
	 int ant, indice;
	 if ( this.lista[ this.nc ].elo == -1 )
		 throw new RuntimeException("Underflow");
	 else {
		 ant = nc;
		 indice = this.lista[ this.nc ].elo;
		 while( indice != -1 ) {
			 if ( valor == this.lista[ indice ].info )
				 break;
			 ant = indice;
			 indice = this.lista[ indice ].elo;
		 }
		 if ( indice == -1 )
			 throw new RuntimeException("Valor não encontrado");
		 else{
			 this.lista[ ant ].elo = this.lista[ indice ].elo;
			 if ( this.lista[ this.nc ].elo == -1 )
				 this.lista[ this.nc ].info = -1; 
			 else
				 if ( this.lista[ indice ].elo == -1 )
					 this.lista[ this.nc ].info = ant;
				 this.libera( indice );
		 }
	 }
	}
	
	public void imprime() {
		for (int i = 0; i < lista.length; i++) {
			System.out.print(disp == i ? "DISP -> " : "        ");
			System.out.print(nc == i ? "NC ->   " : "        ");
			System.out.printf("|  %d   |", lista[i].info);
			System.out.println(lista[i].elo >= 0 ? "  "+ lista[i].elo + " |" : " " + lista[i].elo + " |");
		}
	}
}
