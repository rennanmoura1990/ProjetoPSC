package model.enums;
/**
 * HM = Hor�rio Manh�
 * HT = Hor�rio Tarde
 * @author rennanmoura
 *
 */
public enum Horarios {
	HM1("7:30-8:20",1),HM2("8:20-9:10",2),HM3("9:40-10:30",3),HM4("10:30-11:20",4),HM5("11:20-12:10",5),HM6("12:10-13:00",6),
	HT1("13:30-14:20",7),HT2("14:20-15:10",8),HT3("15:10-16:00",9),HT4("16:30-17:20",10),HT5("17:20-18:10",11),HT6("18:10-19:00",12);
	private final String horario;
	private final int horarioID;
	private Horarios(String horario,int horarioID) {
		this.horario = horario;
		this.horarioID = horarioID;
	}
	public String getHorario() {
		return this.horario;
	}
	public int getHorarioID(){
		return this.horarioID;
	}
}
