package br.com.hospital.bean;

public class Pacientes {
   
	
	 private String nome;
	 private  String convenio;

	public Pacientes(String nome, String convenio) {
		super();
		this.nome = nome;
		this.convenio = convenio;
	}
	
	public Pacientes() {
		super();
	}
	
   
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getConvenio() {
		return convenio;
	}
	public void setConvenio(String convenio) {
		this.convenio = convenio;
	}
	
	
	
	
	
	
	
	
	
	
}
