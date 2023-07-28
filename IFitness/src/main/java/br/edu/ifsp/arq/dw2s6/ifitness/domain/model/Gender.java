package br.edu.ifsp.arq.dw2s6.ifitness.domain.model;

public enum Gender {
	
	MASCULINO("Masculino"),
	FEMININO("Feminino"),
	OUTRO("Outro"),
	PREFIRO_NAO_RESPONDER("Prefiro não responder");
	
	private String description;
	
	private Gender(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
