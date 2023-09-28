package br.edu.ifsp.arq.dw2s6.iftiness.domain.model;

public enum ActivityType {
	
	CAMINHADA("Caminhada"),
	CICLISMO("Ciclismo"),
	CORRIDA("Corrida"),
	NATACAO("Natação");
	
	private String type;
	
	ActivityType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
}
