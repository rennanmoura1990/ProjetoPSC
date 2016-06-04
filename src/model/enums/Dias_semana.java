package model.enums;

public enum Dias_semana {
		DOMINGO("Domingo",1),SEGUNDA("Segunda-Feira",2),TERCA("Terça-Feira",3),
		QUARTA("Quarta-Feira",4),QUINTA("Quinta-Feira",5),SEXTA("Sexta-Feira",6),SABADO("Sabádo",7);
		private final String diasemana;
		private final int diasemanaID;
		private Dias_semana(String diasemana,int diasemanaID){
			this.diasemana = diasemana;
			this.diasemanaID = diasemanaID;
		}
		public String getDiasemana(){
			return this.diasemana;
		}
		public int getDiasemanaID(){
			return this.diasemanaID;
		}
}
