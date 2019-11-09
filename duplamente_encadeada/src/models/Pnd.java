package models;

public class Pnd {
	private int disp, nc, TAMANHO;
	private Nodo[] lista;

	public Pnd(int tamanho) {
		this.TAMANHO = tamanho;
		this.lista = new Nodo[TAMANHO];

		this.criacaoPnd();
		this.cria_nc();
	}
	
	public Nodo[] getLista() {
		return lista;
	}

	public void inclusao(int valor) throws RuntimeException {
		int post, indice;
		indice = obtem();
		if (indice == -1)
			throw new RuntimeException("OVERFLOW!");
		else {
			lista[indice].setInfo(valor);
			post = lista[nc].getElo_p();
			while (post != nc) {
				if (valor < lista[post].getInfo())
					break;
				post = lista[post].getElo_p();
			}
			lista[indice].setElo_p(post);
			lista[indice].setElo_a(lista[post].getElo_a());
			lista[lista[indice].getElo_a()].setElo_p(indice);
			lista[lista[indice].getElo_p()].setElo_a(indice);

		}

	}

	public int retirada(int valor) throws RuntimeException {
		int indice;
		if (lista[nc].getElo_p() == nc) throw new RuntimeException("UNDERFLOW!");
		else {
			indice = lista[nc].getElo_p();
			while (indice != nc) {
				if (valor == lista[indice].getInfo()) break;
				indice = lista[indice].getElo_p();
			}
			if (indice == nc) throw new RuntimeException("Valor não encontrado");
			else {
				lista[lista[indice].getElo_a()].setElo_p(lista[indice].getElo_p());
				lista[lista[indice].getElo_p()].setElo_a(lista[indice].getElo_a());
				libera(indice);
				return valor;
			}
		}
	}

	private void libera(int indice) {
		lista[ indice ].setElo_p(disp);
		disp = indice;

	}

	private void cria_nc() throws RuntimeException {
		nc = obtem();
		if (nc == -1)
			throw new RuntimeException("Nao eh possivel criar NC");

		lista[nc].setElo_a(nc);
		lista[nc].setElo_p(nc);
	}

	private int obtem() {
		int aux;
		if (disp == -1)
			return -1;
		aux = disp;
		disp = lista[disp].getElo_p();
		return aux;
	}

	private void criacaoPnd() {
		int i = 0;
		while (i < TAMANHO - 1) {
			lista[ i ].setElo_p(i+1);
			i++;
		}
		lista[TAMANHO - 1].setElo_p(-1);
		disp = 0;

	}
}
