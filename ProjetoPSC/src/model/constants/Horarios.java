package model.constants;
/**
 * HM = Horario Manha
 * HT = Horario Tarde
 * @author rennanmoura
 *
 */
public enum Horarios {
	HM1("7:30-8:20"),HM2("8:20-9:10"),HM3("9:40-10:30"),HM4("10:30-11:20"),HM5("11:20-12:10"),HM6("12:10-13:00"),
	HT1("13:30-14:20"),HT2("14:20-15:10"),HT3("15:10-16:00"),HT4("16:30-17:20"),HT5("17:20-18:10"),HT6("18:10-19:00");
	private final String horario;
	private Horarios(String horario) {
		this.horario = horario;
	}
	public String getHorario() {
		return this.horario;
	}
}
