package models;

public class Nodo {
	private int elo_a, info, elo_p;

	public Nodo(int elo_p) {
		this.elo_p = elo_p;
	}

	public int getElo_a() {
		return elo_a;
	}

	public void setElo_a(int elo_a) {
		this.elo_a = elo_a;
	}

	public int getInfo() {
		return info;
	}

	public void setInfo(int info) {
		this.info = info;
	}

	public int getElo_p() {
		return elo_p;
	}

	public void setElo_p(int elo_p) {
		this.elo_p = elo_p;
	}

	@Override
	public String toString() {
		return getElo_a() + "|" + getInfo() + "|" + getElo_p();
	}
}
