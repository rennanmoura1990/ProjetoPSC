package model.enums;

public enum Status {
	APROVADO_PORNOTA("Aprovado por NOTA"),RECUPERACAO("Recuperacao"),REPROVADO_PORNOTA("Reprovado por Nota")
	,REPROVADO_PORFALTA("Reprovado por falta"),NADA("Não definido");
	private final String status;
	private Status(String status){
		this.status = status;
	}
	public String getStatus(){
		return this.status;
	}
}
