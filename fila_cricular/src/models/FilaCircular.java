package models;

public class FilaCircular {
	private int dados[];
	private int r, f, tam;
	
	public FilaCircular(int tam) {
		dados = new int[tam];
		this.tam = tam;
		r = f = -1;
	}
	
	public void inclusao(int valor ) throws RuntimeException {
	 if ( ( r == tam && f <= 0 ) || ( r != tam && r+1 == f ) )
		 throw new RuntimeException("Overflow");
	 else{
		 if ( r == tam )
			 r = 0;
		 else
			 r++;
		 dados[ r ] = valor;
	 }
	}
	
	public void retirada() throws RuntimeException {
	 int valor;
	 if ( r == f ) 
		 throw new RuntimeException("Underflow");
	 else{
		 if ( f == tam ){
			 valor = dados[ 0 ]; 
			 f = 0;
		 }
		 else{
			 valor = dados[ f+1 ];
			 f++;
		 }
		 if ( f == r )
			 f = r = -1;
	 }
	}
	
	public boolean isVazia() {
		return this.dados.length == 0;
	}
	
	public void imprime() {
		for (int i = 0; i < dados.length; i++) {
			System.out.print(dados[i] + " |");
		}
		System.out.println();
	}
}
