package br.com.hospital.bean;

public class Leitos {
	private int numeroLeitos;
	private String local;

	public Leitos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leitos(int numeroLeitos, String local) {
		super();
		this.numeroLeitos = numeroLeitos;
		this.local = local;
	}

	public int getNumeroLeitos() {
		return numeroLeitos;
	}

	public void setNumeroLeitos(int numeroLeitos) {
		this.numeroLeitos = numeroLeitos;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

}
