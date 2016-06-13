package model.enums;

public enum Unidades {
	PRIMEIRA("1ª Unidade",1),SEGUNDA("2ª Unidade",2),TERCEIRA("3ª Unidade",3),QUARTA("4ª Unidade",4),RECUPERACAO("Recuperacao",5);
	private final String unidade;
	private final int unidadeId;
	private Unidades(String unidade,int unidadeId){
		this.unidade = unidade;
		this.unidadeId = unidadeId;
	}
	public String getUnidade(){
		return this.unidade;
	}
	public int getUnidadeId(){
		return this.unidadeId;
	}
}
